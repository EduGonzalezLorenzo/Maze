//El canvas sobre el que se dibujará el tablero
const canvas = document.getElementById("canvas");
const ctx = canvas.getContext("2d");

//Variables de animación
let start;
let previousTimeStamp;
let done = false;
let frame = 1;

//Declaración de imagenes.

const playerImg = new Image();

playerImg.src = "/Maze/src/main/webapp/img/link.png";

//Funciones
function drawCanvas() {
    ctx.font = "gameFont";

    drawPlayer();
}

// function drawArrows() {
//     ctx.drawImage(topArrow, 680, 480, 50, 50);
//     ctx.drawImage(leftArrow, 620, 540, 50, 50);
//     ctx.drawImage(botArrow, 680, 540, 50, 50);
//     ctx.drawImage(righttArrow, 740, 540, 50, 50);
// }

function drawPlayer() {
    ctx.drawImage(playerImg, 968, 780, 100, 140, 325, 250, 120, 120);
}


canvas.addEventListener("mousedown", function (event) {
    clickAnalizer();
});

function clickAnalizer() {
    const boundingRect = canvas.getBoundingClientRect();
    const posX = (Math.floor(event.clientX - boundingRect.left));
    const posY = (Math.floor(event.clientY - boundingRect.top));

    manageCoordenades(posX, posY);

}

function manageCoordenades(posX, posY) {
    checkArrowClick(posX, posY);
}


function checkArrowClick(posX, posY) {
    ctx.globalCompositeOperation = 'destination-over';
    ctx.clearRect(325, 250, 120, 120);
    if (posX > 680 && posX < 730 && posY > 480 && posY < 540) {
        console.log("up");
        window.requestAnimationFrame(moveUp);
    } else if (posX > 620 && posX < 670 && posY > 540 && posY < 590) {
        y = 650;
        window.requestAnimationFrame(moveLeft);
    } else if (posX > 680 && posX < 730 && posY > 540 && posY < 590) {
        y = 520;
        window.requestAnimationFrame(moveDown);
    } else if (posX > 740 && posX < 790 && posY > 540 && posY < 590) {
        y = 920;
        window.requestAnimationFrame(moveRight);
    }
}

function moveUp(timestamp) {
    if (start === undefined) {
        start = timestamp;
    }
    const elapsed = timestamp - start;

    if (previousTimeStamp !== timestamp) {
        const count = Math.floor(0.1 * elapsed, 200);
        ctx.clearRect(325, 250 - count, 120, 120);
        ctx.drawImage(
            playerImg,
            242 * frame, 780,
            100, 140,
            325, 250 - count,
            120, 120);
        if (count % 20 == 0) {
            frame++;
            if (frame > 5) {
                frame = 1;
            }
        }
        if (count === 200) done = true;
    }

    if (elapsed < 4000) {
        previousTimeStamp = timestamp;
        if (!done) {
            window.requestAnimationFrame(moveUp);
        } else {
            window.location.assign("/nav?dir=N");
        }
    }
}
function moveLeft() {
    ctx.drawImage(playerImg, 10, 650, 100, 140, 325, 250, 120, 120);
}
function moveDown() {
    ctx.drawImage(playerImg, 10, 520, 100, 140, 325, 250, 120, 120);
}
function moveRight() {
    ctx.drawImage(playerImg, 10, 920, 100, 140, 325, 250, 120, 120);
}
