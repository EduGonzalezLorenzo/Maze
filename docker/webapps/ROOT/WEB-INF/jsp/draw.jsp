<%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>

            <style>
                <%@include file="./styles.css" %>
            </style>

            <!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
    <title>Dibujar figura</title>
</head>

<body class="bg-info">
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
        <article class="row" id="draw">
            <section class="col-2 bg-light">
                <form  action="/draw" method="POST">
                    <label for="figName">Nombre de la figura:</label>
                    <input type="text" id="figName" name="figName">
                    <label for="shape">Seleccione una figura:</label>
                    <select name="shape" id="shape" onchange="drawButton()">
                        <option value="circle">Círculo</option>
                        <option value="square">Cuadrado</option>
                        <option value="triangle">Triángulo</option>
                        <option value="pentagon">Pentágono</option>
                        <option value="star">Estrella de 7 puntas</option>
                    </select>
                    <br>
                    <label for="color">Seleccione un color para la figura:</label>
                    <select name="color" id="color" onchange="drawButton()">
                        <option value="black">Negro</option>
                        <option value="green">Verde</option>
                        <option value="red">Rojo</option>
                        <option value="blue">Azul</option>
                        <option value="yellow">Amarillo</option>
                        <option value="gray">Gris</option>
                    </select>
                    <br>
                    <label for="xCoor">Coordenada x: </label>
                    <input type="number" id="xCoor" name="xCoor" onchange="drawButton()" required>
                    <label for="yCoor">Coordenada y: </label>
                    <input type="number" id="yCoor" name="yCoor" onchange="drawButton()" required>
                    <br>
                    <label for="size">Seleccione tamaño de la figura:</label>
                    <input type="range" min="10" max="700" value="250" id="sizeRange" name="sizeRange"
                        oninput="this.form.size.value=this.value" onchange="drawButton()">
                    <input type="number" min="10" max="700" value="250" name="size" id="size"
                        oninput="this.form.sizeRange.value=this.value" onchange="drawButton()">
                    <p>Para dibujar clica en el tablero o rellena el formulario a mano y clica en siguiente
                        boton.</p>
                    <button type="button" onclick="drawButton()">Dibujar</button>
                    <input type="submit" value="Enviar">
                </form>
            </section>
            <section class="col-10">
                <canvas class="bg-white" id="canvas" width="1024" height="768" style="border:1px solid #000000;"></canvas>
            </section>
            

        </article>

    </main>
    <script>
        const canvas = document.getElementById("canvas");
        const ctx = canvas.getContext("2d");
        const boundingRect = canvas.getBoundingClientRect();

        canvas.addEventListener("mousedown", function (event) {
            getData();
        });

        function drawButton() {
            ctx.clearRect(0, 0, canvas.width, canvas.height);
            let x = parseInt(document.getElementById("xCoor").value);
            let y = parseInt(document.getElementById("yCoor").value);
            let shape = document.getElementById("shape").value;
            let color = document.getElementById("color").value;
            let size = parseInt(document.getElementById("size").value);
            drawFigure(shape, x, y, color, size);
        }

        function getData() {
            ctx.clearRect(0, 0, canvas.width, canvas.height);
            let x = Math.floor(event.clientX - boundingRect.left);
            let y = Math.floor(event.clientY - boundingRect.top);
            let shape = document.getElementById("shape").value;
            let color = document.getElementById("color").value;
            let size = parseInt(document.getElementById("size").value);
            drawFigure(shape, x, y, color, size);
            document.getElementById("xCoor").value = x;
            document.getElementById("yCoor").value = y;
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