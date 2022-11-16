//El canvas sobre el que se dibujará el tablero
const canvas = document.getElementById("canvas");
const ctx = canvas.getContext("2d");

let columns = 20;
let rows = 15;

let cellWidth = canvas.width / columns;
let cellHeight = canvas.height / rows;

const topArrow = new Image();
const botArrow = new Image();
const righttArrow = new Image();
const leftArrow = new Image();


topArrow.src = "../img/Arrow_Up.png";
leftArrow.src = "../img/Arrow_Left.png";
botArrow.src = "../img/Arrow_Down.png";
righttArrow.src = "../img/Arrow_Right.png";


function drawCanvas() {
    drawArrows();
    drawCurrentRoom();
}

function drawArrows() {
    ctx.drawImage(topArrow, 680, 480, 50, 50);
    ctx.drawImage(leftArrow, 620, 540, 50, 50);
    ctx.drawImage(botArrow, 680, 540, 50, 50);
    ctx.drawImage(righttArrow, 740, 540, 50, 50);
}

function drawCurrentRoom(){
    let dataScript = document.getElementById("gameJson").textContent;
    let data = JSON.parse(dataScript);
    let room = new Object();
    let player = new Object();
    room = data.Room;
    player = data.Player;
    console.log(room);
    console.log(player);
}

canvas.addEventListener("mousedown", function (event) {
    clickHandler();
});

function clickHandler() {
    const boundingRect = canvas.getBoundingClientRect();
    const posX = (Math.floor(event.clientX - boundingRect.left));
    const posY = (Math.floor(event.clientY - boundingRect.top));
    console.log(posX + " / " + posY);

    manageCoordenades(posX, posY);
}

function manageCoordenades(posX, posY) {
    checkArrowClick(posX, posY);
}

function checkArrowClick(posX, posY) {
    if (posX > 680 && posX < 730 && posY > 480 && posY < 540) {
        console.log("UP");
        window.location.assign("http://localhost:8080/nav?dir=N");
    } else if (posX > 620 && posX < 670 && posY > 540 && posY < 590) {
        console.log("LEFT");
        window.location.assign("http://localhost:8080/nav?dir=W");
    } else if (posX > 680 && posX < 730 && posY > 540 && posY < 590) {
        console.log("DOWN");
        window.location.assign("http://localhost:8080/nav?dir=S");
    } else if (posX > 740 && posX < 790 && posY > 540 && posY < 590) {
        console.log("RIGHT");
        window.location.assign("http://localhost:8080/nav?dir=E");
    }
}