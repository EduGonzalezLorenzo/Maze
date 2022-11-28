//El canvas sobre el que se dibujará el tablero
const canvas = document.getElementById("canvas");
const ctx = canvas.getContext("2d");

//Declaración de imagenes.
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

const playerImg = new Image();
const key = new Image();
const coin = new Image();

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

playerImg.src = "../img/link.png";
key.src = "../img/key.png";
coin.src = "../img/coin.png";

//Carga del json
const dataScript = document.getElementById("gameJson").textContent;
const data = JSON.parse(dataScript);

//Funciones
function drawCanvas() {
    ctx.font = "gameFont";
    drawArrows();
    drawPlayer();
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

function drawPlayer() {
    ctx.drawImage(playerImg, 10, 0, 100, 140, 225, 215, 120, 120);
}

function drawCurrentInventory(player) {
    ctx.font = "25px gameFont ";
    ctx.fillText("Coins", 650, 200);
    ctx.fillText(player.Coins, 680, 225);
    ctx.fillText("Keys", 650, 275);
    ctx.fillText(player.Keys, 680, 300);
}

function drawCurrentRoom(room) {
    drawSideHor(room.N, 10, 10, 550, 50);
    drawSideVer(room.W, 10, 50, 50, 450);
    drawSideHor(room.S, 10, 500, 550, 50);
    drawSideVer(room.E, 510, 50, 50, 450);
    drawItems(room);
    if (room.msg !== null) {
        ctx.font = "15px gameFont ";
        ctx.fillText(room.msg, 100, 100);
    }
    ctx.font = "25px gameFont";
    ctx.fillText("Room", 650, 100);
    ctx.fillText(room.roomNumber, 680, 125);
}

function drawItems(room) {
    if (room.Coins == 1) {
        ctx.drawImage(coin, 100, 400, 80, 80);
    } if (room.Keys == 1) {
        ctx.drawImage(key, 400, 400, 80, 80);
    }
}

function drawSideHor(side, x, y, width, height) {
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

function drawSideVer(side, x, y, width, height) {
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

canvas.addEventListener("mousedown", function (event) {
    clickAnalizer();
});

function clickAnalizer() {
    const boundingRect = canvas.getBoundingClientRect();
    const posX = (Math.floor(event.clientX - boundingRect.left));
    const posY = (Math.floor(event.clientY - boundingRect.top));
    let game = new Object();
    game = data.Game;
    if (game.gameStatus == true) {
        window.location.assign("/endform");
    } else {
        let room = new Object();
        room = data.Room;
        manageCoordenades(posX, posY, room);
    }
}

function manageCoordenades(posX, posY, room) {
    if (room.Coins != 0) {
        checkCoinClick(posX, posY);
    } if (room.Keys != 0) {
        checkKeyClick(posX, posY);
    }
    checkArrowClick(posX, posY);
    checkDoorClik(posX, posY);
}

function checkDoorClik(posX, posY) {
    if (posX > 225 && posX < 335 && posY > 10 && posY < 60) {
        window.location.assign("/open?dir=N");
    }
    if (posX > 10 && posX < 60 && posY > 230 && posY < 320) {
        window.location.assign("/open?dir=W");
    }
    if (posX > 225 && posX < 335 && posY > 500 && posY < 550) {
        window.location.assign("/open?dir=S");
    }
    if (posX > 510 && posX < 560 && posY > 230 && posY < 320) {
        window.location.assign("/open?dir=E");
    }
}

function checkCoinClick(posX, posY) {
    if (posX > 100 && posX < 180 && posY > 400 && posY < 480) {
        window.location.assign("/getcoin");
    }
}

function checkKeyClick(posX, posY) {
    if (posX > 400 && posX < 480 && posY > 400 && posY < 480) {
        window.location.assign("/getkey");
    }
}

function checkArrowClick(posX, posY) {
    if (posX > 680 && posX < 730 && posY > 480 && posY < 540) {
        ctx.clearRect(90, 80, 400, 30);
        window.requestAnimationFrame(moveUp);
    } else if (posX > 620 && posX < 670 && posY > 540 && posY < 590) {
        ctx.clearRect(90, 80, 400, 30);
        window.requestAnimationFrame(moveLeft);
    } else if (posX > 680 && posX < 730 && posY > 540 && posY < 590) {
        ctx.clearRect(90, 80, 400, 30);
        window.requestAnimationFrame(moveDown);
    } else if (posX > 740 && posX < 790 && posY > 540 && posY < 590) {
        ctx.clearRect(90, 80, 400, 30);
        window.requestAnimationFrame(moveRight);
    }
}

//Variables y funciones de animación
let start;
let previousTimeStamp;
let done = false;
let frame = 1;
let lag = 0;

function moveUp(timestamp) {
    lag++;
    console.log("up");
    if (start === undefined) {
        start = timestamp;
    }
    const elapsed = timestamp - start;

    if (previousTimeStamp !== timestamp) {
        const distance = Math.floor(0.2 * elapsed, 150);
        ctx.clearRect(225, 215 - distance, 120, 120);
        ctx.drawImage(playerImg, 242 * frame, 780, 100, 140, 225, 215 - distance, 120, 120);
        if (lag > 5) {
            frame++;
            if (frame > 4) {
                frame = 1;
            }
            lag = 0;
        }
        if (distance >= 150) done = true;
    }

    if (elapsed < 2000) {
        previousTimeStamp = timestamp;
        if (!done) {
            window.requestAnimationFrame(moveUp);
        } else {
            window.location.assign("/nav?dir=N");
        }
    }
}

function moveLeft(timestamp) {
    lag++;
    console.log("left");
    if (start === undefined) {
        start = timestamp;
    }
    const elapsed = timestamp - start;

    if (previousTimeStamp !== timestamp) {
        const distance = Math.floor(0.2 * elapsed, 150);
        ctx.clearRect(225 - distance, 215, 130, 130);
        ctx.drawImage(playerImg, 242 * frame, 650, 100, 130, 225 - distance, 215, 120, 120);
        if (lag > 5) {
            frame++;
            if (frame > 4) {
                frame = 1;
            }
            lag = 0;
        }
        if (distance >= 150) done = true;
    }

    if (elapsed < 2000) {
        previousTimeStamp = timestamp;
        if (!done) {
            window.requestAnimationFrame(moveLeft);
        } else {
            window.location.assign("/nav?dir=W");
        }
    }
}

function moveDown(timestamp) {
    lag++;
    console.log("down");
    if (start === undefined) {
        start = timestamp;
    }
    const elapsed = timestamp - start;

    if (previousTimeStamp !== timestamp) {
        const distance = Math.floor(0.2 * elapsed, 150);
        ctx.clearRect(225, 215 + distance, 120, 120);
        ctx.drawImage(playerImg, 242 * frame, 520, 100, 140, 225, 215 + distance, 120, 120);
        if (lag > 5) {
            frame++;
            if (frame > 4) {
                frame = 1;
            }
            lag = 0;
        }
        if (distance >= 150) done = true;
    }

    if (elapsed < 2000) {
        previousTimeStamp = timestamp;
        if (!done) {
            window.requestAnimationFrame(moveDown);
        } else {
            window.location.assign("/nav?dir=S");
        }
    }
}

function moveRight(timestamp) {
    lag++;
    console.log("right");
    if (start === undefined) {
        start = timestamp;
    }
    const elapsed = timestamp - start;

    if (previousTimeStamp !== timestamp) {
        const distance = Math.floor(0.2 * elapsed, 150);
        ctx.clearRect(215 + distance, 215, 130, 130);
        ctx.drawImage(playerImg, 242 * frame, 920, 100, 130, 225 + distance, 215, 120, 120);
        if (lag > 5) {
            frame++;
            if (frame > 4) {
                frame = 1;
            }
            lag = 0;
        }
        if (distance >= 150) done = true;
    }

    if (elapsed < 2000) {
        previousTimeStamp = timestamp;
        if (!done) {
            window.requestAnimationFrame(moveRight);
        } else {
            window.location.assign("/nav?dir=E");
        }
    }
}
