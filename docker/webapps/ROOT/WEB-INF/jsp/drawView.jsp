<%@ page isELIgnored="false" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style><%@include file="./styles.css"%></style>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
    <title>Visualización</title>
</head>

<body class="bg-info" onload="drawButton()">
    <header class="fixed-top bg-white">
        <ul class="nav nav-tabs justify-content-around row" role="tablist">
            <li class="nav-item col-4">
                <a class="nav-link text-center active" href="draw">Dibujar</a>
            </li>
            <li class="nav-item col-4">
                <a class="nav-link text-center" href="allFig">Todas las figuras</a>
            </li>
            <li class="nav-item col-4">
                <a class="nav-link text-center" href="profile">Mis figuras</a>
            </li>
        </ul>
    </header>
    <main class="container">
        <article id="drawView" class="row justify-content-center">
            <h1 class="text-center">Muestra de la figura ${figureToDraw.name} del usuario ${figureToDraw.user.name}.</h1>
            <canvas class="col-10 bg-white" id="canvas" width="1024" height="768" style="border:1px solid #000000;"></canvas>
            <input type="hidden" name="xCoor" id="xCoor" value=${figureToDraw.x}>
            <input type="hidden" name="yCoor" id="yCoor" value=${figureToDraw.y}>
            <input type="hidden" name="shape" id="shape" value=${figureToDraw.shape}>
            <input type="hidden" name="color" id="color" value=${figureToDraw.color}>
            <input type="hidden" name="size" id="size" value=${figureToDraw.size}>               
        </article>
    </main>

    <script>
        const canvas = document.getElementById("canvas")
        const ctx = canvas.getContext("2d");
        
        function drawButton() {
            ctx.clearRect(0, 0, canvas.width, canvas.height);
            let x = parseInt(document.getElementById("xCoor").value);
            console.log(x);
            let y = parseInt(document.getElementById("yCoor").value);
            console.log(y);
            let shape = document.getElementById("shape").value;
            console.log(shape);
            let color = document.getElementById("color").value;
            console.log(color);
            let size = parseInt(document.getElementById("size").value);
            console.log(size);
            drawFigure(shape, x, y, color, size);
        }
        function drawFigure(shape, x, y, color, size) {
            switch (shape) {
                case "circle":
                    drawCircle(x, y, color, size);
                    break;
                case "square":
                    drawSquare(x, y, color, size);
                    break;
                case "triangle":
                    drawTriangle(x, y, color, size);
                    break;
                case "pentagon":
                    drawPengaton(x, y, color, size);
                    break;
                case "star":
                    drawStar(x, y, color, size);
                    break;
                default:

            }
        }
        function drawCircle(x, y, color, size) {
            ctx.beginPath();
            ctx.arc(x, y, size / 2, 0, 2 * Math.PI);
            ctx.stroke();
            ctx.fillStyle = color;
            ctx.fill();
        }
        function drawSquare(x, y, color, size) {
            let radius = size / 2;
            ctx.beginPath();
            ctx.rect(x - radius, y - radius, size, size);;
            ctx.stroke();
            ctx.fillStyle = color;
            ctx.fill();
        }
        function drawTriangle(x, y, color, size) {
            let height= (Math.sqrt(3)*size)/2;
            x -= (height/2);
            y += (height/2);
            ctx.beginPath();
            ctx.moveTo(x, y);
            ctx.lineTo(x+size, y);
            ctx.lineTo(x+size/2, y-height);
            ctx.lineTo(x+(size)/2, y-height);
            ctx.lineTo(x,  y);
            ctx.stroke();
            ctx.fillStyle = color;
            ctx.fill();
        }
        function drawPengaton(x, y, color, size) {
            let side = 2 * Math.PI / 5;
            let turnAngle = (Math.PI / 180.0) * - 0.05;

            ctx.beginPath();
            for (let i = 0; i <= 5; i++) {
                let curStep = i * (side + turnAngle);
                ctx.lineTo(x + (size * Math.cos(curStep)) / 2, y + (size * Math.sin(curStep)) / 2);
            }
            ctx.stroke();
            ctx.fillStyle = color;
            ctx.fill();
        }
        function drawStar(x, y, color, size) {
            let outerRadius = size/2;
            let innerRadius = outerRadius / 4;
            let rotAngle = Math.PI / 2 * 3;
            let step = Math.PI / 7;
            let newX = x;
            let newY = y;
            
            ctx.beginPath();
            ctx.moveTo(x, y - outerRadius)
            for (i = 0; i < 7; i++) {
                newX = x + Math.cos(rotAngle) * outerRadius;
                newY = y + Math.sin(rotAngle) * outerRadius;
                ctx.lineTo(newX, newY)
                rotAngle += step

                newX = x + Math.cos(rotAngle) * innerRadius;
                newY = y + Math.sin(rotAngle) * innerRadius;
                ctx.lineTo(newX, newY)
                rotAngle += step
            }
            ctx.lineTo(x, y - outerRadius);
            ctx.closePath();
            ctx.lineWidth = 5;
            ctx.strokeStyle = color;
            ctx.stroke();
            ctx.fillStyle = color;
            ctx.fill();

        }

    </script>
</body>

</html>