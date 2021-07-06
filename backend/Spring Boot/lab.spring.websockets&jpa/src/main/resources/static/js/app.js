var stompClient = null;
let subscribing = false;
let messagesQueue = [];

let showCounter = 0;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
}

function connect() {
    var socket = new SockJS('/thedfa-communicationshub');
    let headers = { user :  $('#name').val()}
    if ( $("#name").val() === "" ){
		alert("User vacio");
		return;
	}
    stompClient = Stomp.over(socket);
    stompClient.connect(headers, function (frame) {
                                setConnected(true);
                                // Pedir todos
                                console.log('Connected: ' + frame);
                                	stompClient.subscribe('/topic/verbose', callback);
                            }
    );
}

// Función que permite hacer la subscripción y cargar los mensajes en la pila 
// y luego mostrarlos. 
// En el caso de que solo llegue un mensaje y ya se hayan mostrados los demás mensajes de la cola, 
// se mostrará este último.
callback = function (msg){
	subscribing == true;
    let messageJSON = JSON.parse(msg.body)
	console.log("TRACE: " + messageJSON);
	console.log("TIPO: " + typeof messageJSON);
	console.log("OBJ: " +  messageJSON)
	
	if(subscribing === false){
		subscribingToAndEnqueuing(messageJSON);
		} if (messagesQueue.length > 0){
			showMessages();
		}
		else {
			console.log("TRACE callback content message  " + messageJSON.content);
			console.log("TRACE callback username message   " + messageJSON.username);
			show(messageJSON);
		}
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendMessage() {
    stompClient.send("/app/send", {}, JSON.stringify({'content': $("#content").val(), 'username': $("#name").val()}));
}

function show(message) {
	
	console.log("TRACE show counter: " + ++showCounter);
	
	 console.log("TRACE message received: " + message.content);
	 	 
    var now = new Date();
            console.log(now);
            var d = now.getDate();
            var m = now.getMonth()+1;
            var y = now.getFullYear();
            var h = now.getHours();
            var min = now.getMinutes();

            Fecha = d + "/" + m + "/" + y + "  " + h + ":" + min;
                  
      console.log(message.content);
      console.log("MESSAGE TRACE 1: " + message.content);
      var li = $("#inboundtemplate").clone();
      li.appendTo("#chat");
      li.find("#username").html(message.username)
      li.find( "p" ).html( message.content );
      li.find("#timestamp").html(Fecha);
      li.show();
      console.log("MESSAGE TRACE 2: " + message.content);

}

//Al subscribirse obtiene una lista de mensajes que se encolan en messagesQueue, 
//para posteriormente mostrarlos y desencolarlos.
function subscribingToAndEnqueuing(messageJSON){
	susbcribing = true;
	if(messageJSON instanceof Array) {
		console.log("TRACE Longitud del array: " + messageJSON.length);
		messageJSON.map(function(m) {
				console.log("TRACE push : " + m.content);
				console.log(messagesQueue.push(m));
		});
		console.log(messagesQueue);
		console.log(messagesQueue.length);
	 }
	subscribing = false;
}

//Muestra y desencola los mensajes contenido en messagesQueue,
//espera en el caso de que subscribing = true.
function showMessages(){
	while (subscribing === true){
		setTimeout(() => {
			console.log("Waiting....")
		}, 500);
	}
	console.log("TRACE messages: " + messagesQueue);
	while (messagesQueue.length > 0 ) 
		show(messagesQueue.shift())
	console.log(messagesQueue.length);
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
});

$(document).ready(
    function() {
    	
    	console.log("TRACE ready");
    	
        $('#send').click(function(){
            var now = new Date();
            console.log(now);
            var d = now.getDate();
            var m = now.getMonth()+1;
            var y = now.getFullYear();
            var h = now.getHours();
            var min = now.getMinutes();

            Fecha = d + "/" + m + "/" + y + "  " + h + ":" + min;
            
            sendMessage();

            var message = $("#content").val();
            var li = $("#outboundtemplate").clone();
            li.appendTo("#chat");
            li.find("#me").html($("#name").val());
            li.find( "p" ).html( message );
            li.find("#timestamp").html(Fecha);
            console.log("Li.show TRACE: " + message);
            li.show();
            
        });

    }
);          