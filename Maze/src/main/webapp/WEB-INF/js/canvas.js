//El canvas sobre el que se dibujará el tablero
const canvas = document.getElementById("canvas");
const ctx = canvas.getContext("2d");

let columns = 20;
let rows = 15;

let cellWidth = canvas.width / columns;
let cellHeight = canvas.height / rows;

const background = new Image();
background.src = "../img/Minesweeper_unopened_square.png";

const topArrow = new Image();
const botArrow = new Image();
const righttArrow = new Image();
const leftArrow = new Image();

topArrow.src = "../img/Arrow_Up.png";
leftArrow.src = "../img/Arrow_Left.png";
botArrow.src = "../img/Arrow_Down.png";
righttArrow.src = "../img/Arrow_Right.png";


function drawBoard() {
    //Función que dibuja el tablero del buscaminas con unas dimensiones de "rows" filas y "columns" columnas.
    for (let row = 0; row <= rows; row++) {
        for (let column = 0; column <= columns; column++) {
            const y = row * cellHeight;
            const x = column * cellWidth;
            ctx.drawImage(background, x, y, cellWidth, cellHeight);
        }
    }
    drawArrows();
}

function drawArrows() {
    ctx.drawImage(topArrow, 680, 480, 50, 50);
    ctx.drawImage(leftArrow, 620, 540, 50, 50);
    ctx.drawImage(botArrow, 680, 540, 50, 50);
    ctx.drawImage(righttArrow, 740, 540, 50, 50);
}

canvas.addEventListener("mousedown", function (event) {
    clickHandler();
});

function clickHandler() {
    const boundingRect = canvas.getBoundingClientRect();
    const posX = (Math.floor(event.clientX - boundingRect.left));
    const posY = (Math.floor(event.clientY - boundingRect.top));
    console.log(posX + " / " + posY);

    // Navigation

    if (posX > 680 && posX < 730 && posY > 480 && posY < 540) {
        navigateDungeon("up");
    } else if (posX > 620 && posX < 670 && posY > 540 && posY < 590) {
        navigateDungeon("left");
    } else if (posX > 680 && posX < 730 && posY > 540 && posY < 590) {
        navigateDungeon("down");
    } else if (posX > 740 && posX < 790 && posY > 540 && posY < 590) {
        navigateDungeon("right");
    }

    // Doors

    if (posX > 440 && posX < 480 && posY > 60 && posY < 100) {
        openDoor("up");
    }
    if (posX > 440 && posX < 480 && posY > 260 && posY < 300) {
        openDoor("down");
    }
    if (posX > 340 && posX < 380 && posY > 160 && posY < 200) {
        openDoor("left");
    }
    if (posX > 540 && posX < 580 && posY > 160 && posY < 200) {
        openDoor("right");
    }

    // Key

    if (posX > 380 && posX < 415 && posY > 100 && posY < 135) {
        getKey();
    }

    // Coin

    if (posX > 500 && posX < 535 && posY > 100 && posY < 135) {
        getCoin();
    }


}

function navigateDungeon(direction) {
    let moveTo = direction;

    switch (moveTo) {
        case "up":
            console.log("Moving UP !!!")
            window.location.assign("http://localhost:8080/nav?dir=N")
            break;
        case "down":
            console.log("Moving DOWN !!!")
            window.location.assign("http://localhost:8080/nav?dir=S")
            break;
        case "left":
            console.log("Moving LEFT !!!")
            window.location.assign("http://localhost:8080/nav?dir=E")
            break;
        case "right":
            console.log("Moving RIGHT !!!")
            window.location.assign("http://localhost:8080/nav?dir=W")
            break;
        default:
            console.log("NOT A DIRECTION")
            break;
    }
}