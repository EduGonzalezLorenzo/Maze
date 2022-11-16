//El canvas sobre el que se dibujará el tablero
const canvas = document.getElementById("canvas");
const ctx = canvas.getContext("2d");
ctx.font = "20px gameFont";

let columns = 20;
let rows = 15;

let cellWidth = canvas.width / columns;
let cellHeight = canvas.height / rows;

const topArrow = new Image();
const botArrow = new Image();
const righttArrow = new Image();
const leftArrow = new Image();

const wallHor = new Image();
const wallVer = new Image();
const DoorOpenHor = new Image();
const DoorOpenVer = new Image();
const DoorClosedHor = new Image();
const DoorClosedVer = new Image();

topArrow.src = "../img/Arrow_Up.png";
leftArrow.src = "../img/Arrow_Left.png";
botArrow.src = "../img/Arrow_Down.png";
righttArrow.src = "../img/Arrow_Right.png";

wallHor.src = "../img/MuroHorizontal.png";
wallVer.src = "../img/MuroVertical.png";
DoorOpenHor.src = "../img/PuertaAbiertaHorizontal.png";
DoorOpenVer.src = "../img/PuertaAbiertaVertical.png";
DoorClosedHor.src = "../img/PuertaCerradaHorizontal.png";
DoorClosedVer.src = "../img/PuertaCerradaVertical.png";

function drawCanvas() {
    drawArrows();
    let dataScript = document.getElementById("gameJson").textContent;
    let data = JSON.parse(dataScript);
    let room = new Object();
    let player = new Object();
    room = data.Room;
    player = data.Player;
    drawCurrentRoom(room);
    drawCurrentInventory(player);
}

function drawArrows() {
    ctx.drawImage(topArrow, 680, 480, 50, 50);
    ctx.drawImage(leftArrow, 620, 540, 50, 50);
    ctx.drawImage(botArrow, 680, 540, 50, 50);
    ctx.drawImage(righttArrow, 740, 540, 50, 50);
}


function drawCurrentInventory(player){
    ctx.fillText("Coins", 650, 200);
    ctx.fillText(player.Coins, 680, 225);
    ctx.fillText("Keys", 650, 275);
    ctx.fillText(player.Keys, 680, 300);
}

function drawCurrentRoom(room) {
    drawSideHor(room.N, 10, 10, 600, 100);
    drawSideVer(room.W, 10, 50, 100, 500);
    drawSideHor(room.S, 10, 500, 600, 100);
    drawSideVer(room.E, 510, 50, 100, 500);
    ctx.fillText("Room", 650, 100);
    ctx.fillText(room.roomNumber, 680, 125);
}

function drawSideHor(side, x, y, width, height){
    switch (side) {
        case "wall":
            ctx.drawImage(wallHor, x, y, width, height);
            break;
        case "Open door":
            ctx.drawImage(DoorOpenHor, x, y, width, height);
            break;
        case "Close door":
            ctx.drawImage(DoorClosedHor, x, y, width, height);
    }
}

function drawSideVer(side, x, y, width, height){
    switch (side) {
        case "wall":
            ctx.drawImage(wallVer, x, y, width, height);
            break;
        case "Open door":
            ctx.drawImage(DoorOpenVer, x, y, width, height);
            break;
        case "Close door":
            ctx.drawImage(DoorClosedVer, x, y, width, height);
    }
}

function drawPlayerItems(player) {
    console.log("Coins: " + player.Coins);
    console.log("Keys: " + player.Keys);
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