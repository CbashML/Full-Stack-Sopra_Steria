var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }

    //$("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/thedfa-communicationshub');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
                                setConnected(true);
                                console.log('Connected: ' + frame);

                                stompClient.subscribe('/topic/verbose', 
                                    function (greeting) {
                                        show(JSON.parse(greeting.body).content);
                                });
                            }
    );
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
    //$("#messages").append("<tr><td>" + message + "</td></tr>");

    var now = new Date();
            console.log(now);
            var d = now.getDate();
            var m = now.getMonth()+1;
            var y = now.getFullYear();
            var h = now.getHours();
            var min = now.getMinutes();

            Fecha = d + "/" + m + "/" + y + "  " + h + ":" + min;
            
    console.log(message);
     var li = $("#inboundtemplate").clone();
     li.appendTo("#chat");
     li.find( "p" ).html( message );
     li.find("#timestamp").html(Fecha);
     li.show();

}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    /* $( "#send" ).click(function() {  }); */
});

$(document).ready(
    function() {

        //var Nombre= prompt("Nombre:");

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
            TabladeBaseDatos.push({
                Nombre:Nombre,
                Mensaje:$("#Mensaje").val(),
                Fecha:Fecha
            });
            * */

           sendMessage();

            var message = $("#content").val();
            var li = $("#outboundtemplate").clone();
            li.appendTo("#chat");
            li.find( "p" ).html( message );
            li.find("#timestamp").html(Fecha);
            li.show();
        });

    }
);          