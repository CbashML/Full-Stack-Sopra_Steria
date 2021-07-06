var stompClient = null;
let subscribing = false;
let messagesLength = 0;
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

    // $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/thedfa-communicationshub');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
                                setConnected(true);
                                // Pedir todos
                                console.log('Connected: ' + frame);
                                	stompClient.subscribe('/topic/verbose', callback);
                            }
    );
}

//Función que permite hacer la subscripción y cargar los mensajes en la pila y luego mostrarlos
//en el caso de que solo llegue un mensaje y ya se hayan mostrados los demás de la cola, se mostrará este último.
callback = function (msg){
	subscribing == true;
    let messageJSON = JSON.parse(msg.body)
	console.log("TRACE: " + messageJSON);
	console.log("TIPO: " + typeof messageJSON);
	console.log("OBJ: " +  messageJSON)

	messagesLength = messageJSON.length;
	
	if(subscribing === false){
		susbcribing = true;
		if(messageJSON instanceof Array) {
			console.log("TRACE Longitud del array: " + messageJSON.length);
			console.log("TIPO ARRAY instanceof " + msg.body);
			messageJSON.map(function(m) {
				if(m.content.length > 0){
					console.log("TRACE push : " + m.content);
					console.log(messagesQueue.push(m.content));
				}
			});
			console.log(messagesQueue);
			console.log(messagesQueue.length);
		 }
		subscribing = false;
		} if (messagesQueue.length > 0){
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
		else {
			console.log("TRACE callback message  " + messageJSON.content);
			show(messageJSON.content);
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
    stompClient.send("/app/send", {}, JSON.stringify({'content': $("#content").val()}));
}

function show(message) {
    // $("#messages").append("<tr><td>" + message + "</td></tr>");
	
	console.log("TRACE show counter: " + ++showCounter);
	
	 console.log("TRACE message received: " + message);
	
    var now = new Date();
            console.log(now);
            var d = now.getDate();
            var m = now.getMonth()+1;
            var y = now.getFullYear();
            var h = now.getHours();
            var min = now.getMinutes();

            Fecha = d + "/" + m + "/" + y + "  " + h + ":" + min;
            
      console.log(message);
      console.log("MESSAGE TRACE 1: " + message);
      var li = $("#inboundtemplate").clone();
      li.appendTo("#chat");
      li.find( "p" ).html( message );
      li.find("#timestamp").html(Fecha);
      li.show();
      console.log("MESSAGE TRACE 2: " + message);

}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    /* $( "#send" ).click(function() { }); */
});

$(document).ready(
    function() {
    	
    	console.log("TRACE ready");
    	
        connect();
        
        // var Nombre= prompt("Nombre:");

        $('#send').click(function(){
            var now = new Date();
            console.log(now);
            var d = now.getDate();
            var m = now.getMonth()+1;
            var y = now.getFullYear();
            var h = now.getHours();
            var min = now.getMinutes();

            Fecha = d + "/" + m + "/" + y + "  " + h + ":" + min;

            /*
			 * TabladeBaseDatos.push({ Nombre:Nombre,
			 * Mensaje:$("#Mensaje").val(), Fecha:Fecha });
			 */
            
            sendMessage();

            var message = $("#content").val();
            var li = $("#outboundtemplate").clone();
            li.appendTo("#chat");
            li.find( "p" ).html( message );
            li.find("#timestamp").html(Fecha);
            console.log("Li.show TRACE: " + message);
            li.show();
            
        });

    }
);          