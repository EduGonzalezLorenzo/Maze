

let canvas = document.getElementById("navigation_canvas");
const ctx = canvas.getContext("2d");
let scale = 2;

canvas.addEventListener("mousedown", function (event) {
    clickHandler();
  });


function drawUI() {
    const background = new Image();
    background.src = "/assets/game_background_test.png"
    background.onload = () => {
        ctx.drawImage(background, 0, 0);
        drawInventory();
    };
}

function drawInventory() {
    // let scale = 2;
    ctx.font = "30px Arial";
    ctx.fillStyle = "white";
    ctx.fillText("Coins: ", 20, 70);
    ctx.fillText("Keys: ", 20, 110);
}

function clickHandler() {
    // let scale = 2;
    const boundingRect = canvas.getBoundingClientRect();
    const posX = (Math.floor(event.clientX - boundingRect.left))/scale;
    const posY = (Math.floor(event.clientY - boundingRect.top))/scale;
    // console.log(posX + " / " +posY);

    // Navigation

    if(posX > 390 && posX < 530 && posY > 0 && posY < 40) {
        navigateDungeon("up");
    }
    if(posX > 390 && posX < 530 && posY > 320 && posY < 360) {
        navigateDungeon("down");
    }
    if(posX > 280 && posX < 320 && posY > 110 && posY < 250) {
        navigateDungeon("left");
    }
    if(posX > 600 && posX < 640 && posY > 110 && posY < 250) {
        navigateDungeon("right");
    }

    // Doors

    if(posX > 440 && posX < 480 && posY > 60 && posY < 100) {
        openDoor("up");
    }
    if(posX > 440 && posX < 480 && posY > 260 && posY < 300) {
        openDoor("down");
    }
    if(posX > 340 && posX < 380 && posY > 160 && posY < 200) {
        openDoor("left");
    }
    if(posX > 540 && posX < 580 && posY > 160 && posY < 200) {
        openDoor("right");
    }

    // Key

    if(posX > 380 && posX < 415 && posY > 100 && posY < 135) {
        getKey();
    }

    // Coin

    if(posX > 500 && posX < 535 && posY > 100 && posY < 135) {
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

function openDoor(direction) {
    let openDirection = direction;

    switch (openDirection) {
        case "up":
            console.log("Open UP Direction Door")
            break;
        case "down":
            console.log("Open DOWN Direction Door")
            break;
        case "left":
            console.log("Open LEFT Direction Door")
            break;
        case "right":
            console.log("Open RIGHT Direction Door")
            break;
        default:
            console.log("NOT A DIRECTION")
            break;
    }
}

function getKey() {
    console.log("get Key!");
}

function getCoin() {
    console.log("get Coin!");
}

function drawWall(position) {

    const wallLR = new Image();
    wallLR.src = "/assets/wall_image.png"
    const wallUD = new Image();
    wallUD.src = "/assets/wall_image_2.png"

    let drawPosition = position;

    switch (drawPosition) {
        case "up":
            wallUD.onload = () => {
                ctx.drawImage(wallUD, 420, 73);
            };
            break;
        case "down":
            wallUD.onload = () => {
                ctx.drawImage(wallUD, 420, 273);
            };
            break;
        case "left":
            wallLR.onload = () => {
                ctx.drawImage(wallLR, 353, 140);
            };
            break;
        case "right":
            wallLR.onload = () => {
                ctx.drawImage(wallLR, 553, 140);
            };
            break;
        default:
            console.log("NOT A DIRECTION")
            break;
    }
}

function drawDoor(position) {

    const doorLR = new Image();
    doorLR.src = "/assets/door_image.png"
    const doorUD = new Image();
    doorUD.src = "/assets/door_image_2.png"

    let drawPosition = position;

    switch (drawPosition) {
        case "up":
            doorUD.onload = () => {
                ctx.drawImage(doorUD, 420, 62);
            };
            break;
        case "down":
            doorUD.onload = () => {
                ctx.drawImage(doorUD, 420, 262);
            };
            break;
        case "left":
            doorLR.onload = () => {
                ctx.drawImage(doorLR, 342, 140);
            };
            break;
        case "right":
            doorLR.onload = () => {
                ctx.drawImage(doorLR, 542, 140);
            };
            break;
        default:
            console.log("NOT A DIRECTION")
            break;
    }

}

function drawCoin() {
    const coin = new Image();
    coin.src = "/assets/coin_image.png"
    coin.onload = () => {
        ctx.drawImage(coin, 500, 100);
    };
}

function drawKey() {
    const key = new Image();
    key.src = "/assets/key_image.png"
    key.onload = () => {
        ctx.drawImage(key, 380, 100);
    };
}

function drawPlayer() {
    const player = new Image();
    player.src = "/assets/player_front.png"
    player.onload = () => {
        ctx.drawImage(player, 445, 145);
    };
}

let room = JSON.parse(document.getElementById("myjson").textContent);

console.log(room);

function drawRoom(room) {
if(room.walls.W === "Door") {
console.log("true");
} else {
console.log("No true")
}
}

drawUI();
// drawDoor("down");
// drawWall("up");
// drawCoin();
// drawKey();
drawPlayer();
drawRoom();