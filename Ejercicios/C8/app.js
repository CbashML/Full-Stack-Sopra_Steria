//E1
// Dibujar un rectangulo rojo
let canvas = document.getElementById("Canvas1");
let ctx = canvas.getContext("2d");
ctx.fillStyle = "#FF0000";
ctx.fillRect(0, 0, 150, 75);

//EJERCICIO 2
//Dibuja una diagonal
let canvas2 = document.getElementById("Canvas2");
let ctx2 = canvas2.getContext("2d");
ctx2.moveTo(0, 0);
ctx2.lineTo(200, 100);
ctx2.stroke();

//EJERCICIO 3
//Dibuja un circulo
let canvas3 = document.getElementById("Canvas3");
let ctx3 = canvas3.getContext("2d");
ctx3.beginPath();
ctx3.arc(95, 50, 40, 0, 2 * Math.PI);
ctx3.stroke();

//EJERCICIO 4
$(document).ready(function () {
  message = "The title of this web is '" + document.title + "'.";
  document.getElementById("title").innerText = message;
});

//EJERCICIO 5
function changeTitle() {
  let newTitle = document.getElementById("newTitle").value;
  document.title = newTitle;
  message = "The title of this web is '" + document.title + "'.";
  document.getElementById("title").innerText = message;
}

//EJERCICIO 6
function changeText() {
  let content = document.getElementById("exampleText").innerText;
  let dataList = content.split(";");
  for (j = 0; j < dataList.length; j++) {
    alert(dataList[j]);
  }
}

//EJERCICIO 7
function fAlert(fname) {
  let message =
    "The name of the file is '" + fname + "'doesn't have acceptable extension.";
  alert(message);
}

function recognize(fileHandle) {
  let fname = fileHandle.name;
  let message = "Has elegido el archivo '" + fname;
  alert(message);
}

function handleFileSelection(item) {
  let f = item.files[0];
  console.log(f.name);
  let fname = f.name;
  let lastIndex = fname.lastIndexOf(".");
  if (lastIndex == -1) {
    complain(fname);
    return;
  }
  let ext = fname.substr(lastIndex + 1);
  if (ext.toLowerCase() in { txt: "" }) {
    recognize(f);
  } else {
    fAlert(fname);
  }
}

//EJERCICIO 8
//Form validation about mask XXX-XX-XX-XX
function correct() {
  let inObject = document.getElementById("serie");
  let value = inObject.value;
  let currentLength = value.length;
  if (currentLength) {
    let lastChar = value.substring(currentLength - 1);

    if (!/\d/.test(lastChar)) {
      value = value.substring(0, currentLength - 1);
    }

    if (currentLength > 12) {
      value = value.substring(0, currentLength - 1);
    }
    currentLength = value.length;
    switch (currentLength) {
      case 3:
      case 6:
      case 9:
        value += "-";
    }
    inObject.value = value;
  }
}
// Ejercicio 9
function initE9() {
    let message;
    textObj = document.getElementById("textE9");
    let welcome = document.getElementById("welcomeE9");
    let text = getCookieE9("textE9");
    if (text == null || text == '') {
        message = "Don't have the text.";
        text = "";
    } else {
        message = "The text saved is:" + text ;
    }
    welcome.innerHTML = message;
    textObj.value = text;
}

function getCookieE9(cName) {
    let i, k, v, arrCookies = document.cookie.split(";");
    for (i = 0; i < arrCookies.length; i++) {
        k = arrCookies[i].substr(0, arrCookies[i].indexOf("="));
        v = arrCookies[i].substr(arrCookies[i].indexOf("=") + 1);
        k = k.replace(/^\s+$/g, "");
        if (k == cName) {
            return unescape(v);
        }
    }
}

function saveText() {
    setCookieE9("textE9", textObj.value, 10);
}

function setCookieE9(cName, value, exdays) {
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + exdays);
    var cValue = escape(value) + ((exdays == null) ? "" : "; expires=" + exdate.toUTCString());
    document.cookie = cName + "=" + cValue;
}

//EJERCICIO 10
function isBiggerThan() {
    var num1 = document.getElementById('firstNum').value;
    var num2 = document.getElementById('secondNum').value;
    
    if (!isANumber(num1) | !isANumber(num2)) {
        document.getElementById("btResult").innerHTML = "Incorrect input";
    } else {
        document.getElementById("btResult").innerHTML = Boolean(num1 > num2);
    }
}

function isANumber(variable) {
    var regex = /^[0-9]+$/;
    if (variable.match(regex)) {
        return true;
    } else {
        return false;
    }
}
