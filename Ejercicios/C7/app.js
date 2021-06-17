
window.onload = function () {
    $('#e5Content').mouseover( function() {
        $('#e5Content').css({
            'color': 'red',
            'font-size': '110%'
        });
    });

    $('#e5Content').mouseout( function() {
        $('#e5Content').css({
            'color': 'black',
            'font-size': '100%'
        });
    });
    
};

function showAlert(){
    alert("Message...");
    console.log("Message...")
}

function showOrHide(){
    if($('.content').is(":visible"))
        $('.content').hide()
    else
        $('.content').show()
}

function add() {
    let num1 = document.getElementById('num1').value;
    let num2 = document.getElementById('num2').value;

    let result = document.getElementById('result')
    result.innerText = parseFloat(num1) + parseFloat(num2)
}

function addContent(){
    let container = document.getElementById('e4Content');
    let text = "Extra text ....";
    let newParagraph = document.createElement("p");
    let newTextContent = document.createTextNode(text);
    newParagraph.appendChild(newTextContent);
    console.log(newParagraph);
    document.body.insertBefore(newParagraph, container);
}