<%@ page isELIgnored="false" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/css/styles.css"%></style>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/styles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
    <title>MazmorraJuego</title>
</head>

<body class="text-center bg-dark text-light" onload="drawCanvas();">
    <h1>Mazmorra Juego</h1>
    <article class="justify-content-center">
            <canvas class="bg-light" id="canvas" width="800" height="600" style="border:1px solid #000000;"></canvas>
    </article>
    <article class="justify-content-center">
    <a href="/reset">Reiniciar</a>
    </article>
        <article class="justify-content-center">
    <a href="/start">Salir del juego</a>
    </article>
    <script type="application/json" id="gameJson">
        ${gameJson}
    </script>
    <script src="/js/canvas.js">
    </script>
</body>
</html>