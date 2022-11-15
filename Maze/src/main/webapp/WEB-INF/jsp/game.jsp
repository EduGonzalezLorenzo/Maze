<%@ page isELIgnored="false" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- <style><%@include file="./styles.css"%></style> --%>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%-- <link rel="stylesheet" href="styles.css"> --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
    <title>MazmorraJuego</title>
</head>

<body class="text-center bg-primary container">
    <h1>Mazmorra Juego</h1>
    <article class="bg-light row justify-content-center">
            <canvas id="myCanvas" width="200" height="100" style="border:1px solid #000000;"></canvas>
    </article>
    <article>
     <form  action="/nav" method="GET">
            <label for="mazeMap">Selecciones un nivel:</label>
            <select name="mazeMap" id="mazeMap">
                <option value="1">Tutorial</option>
                <option value="2">Normal</option>
            </select>
            <input type="submit" value="Jugar">
        </form>
    </article>
    <script type="application/json">
        ${myjson}
    </script>
    <script>
        let dataScript = document.getElementById("mydata").textContent;
        let data = JSON.parse(dataScript);
    </script>
</body>
</html>