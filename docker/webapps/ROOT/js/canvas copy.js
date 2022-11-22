//El canvas sobre el que se dibujará el tablero
const canvas = document.getElementById("canvas");
const ctx = canvas.getContext("2d");


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
    ctx.drawImage(playerImg, 0, 0, 100, 150, 325, 250, 120, 120);
    // img,sx,sy,swidth,sheight,x,y,width,height
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
    ctx.clearRect(350, 250, 100, 100);

    if (posX > 680 && posX < 730 && posY > 480 && posY < 540) {
        window.requestAnimationFrame(moveUp);
    } else if (posX > 620 && posX < 670 && posY > 540 && posY < 590) {
        moveLeft();
    } else if (posX > 680 && posX < 730 && posY > 540 && posY < 590) {
        moveDown();
    } else if (posX > 740 && posX < 790 && posY > 540 && posY < 590) {
        moveRight();
    }
}

function moveUp(){
    ctx.drawImage(playerImg, 5, 10, 100, 150, 350, 250, 100, 100);
    // img,sx,sy,swidth,sheight,x,y,width,height
}
function moveLeft(){
    ctx.drawImage(playerImg, 12, 295, 70, 120, 350, 250, 100, 100);
    // img,sx,sy,swidth,sheight,x,y,width,height
}
function moveDown(){
    ctx.drawImage(playerImg, 5, 10, 100, 150, 350, 250, 100, 100);
    // img,sx,sy,swidth,sheight,x,y,width,height
}
function moveRight(){
    ctx.drawImage(playerImg, 10, 165, 70, 120, 350, 250, 100, 100);
    // img,sx,sy,swidth,sheight,x,y,width,height
}