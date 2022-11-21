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
    <title>Winners</title>
</head>

<body class="bg-info">
    <main class="container">
        <article id="allFig" class="row justify-content-center">
            <h1 class="text-center">Hall de las leyendas</h1>
            <form action="/start" method="GET">
                <input type="submit" value="Nueva partida">    
            </form>
             <table class="bg-white">
                <tr style="margin-bottom:10px; border: 1px solid black;">
                    <th style="margin-bottom:10px; border: 1px solid black;">Posición</th>
                    <th style="margin-bottom:10px; border: 1px solid black;">ID</th>
                    <th style="margin-bottom:10px; border: 1px solid black;">Nombre de la leyenda</th>
                    <th style="margin-bottom:10px; border: 1px solid black;">Nombre de la mazmorra</th>
                    <th style="margin-bottom:10px; border: 1px solid black;">Tiempo usado</th>
                </tr>
                <c:forEach var="winner" items="${winners}">
                        <tr style="margin-bottom:10px; border: 1px solid black;">
                            <td style="margin-bottom:10px; border: 1px solid black;">${winner.position}</td>
                            <td style="margin-bottom:10px; border: 1px solid black;">${winner.id}</td>
                            <td style="margin-bottom:10px; border: 1px solid black;">${winner.playerName}</td>
                            <td style="margin-bottom:10px; border: 1px solid black;">${winner.mazeName}</td>
                            <td style="margin-bottom:10px; border: 1px solid black;">${winner.formattedTime}</td>
                        </tr>
                </c:forEach>
            </table>
        </article>
    </main>
</body>

</html>