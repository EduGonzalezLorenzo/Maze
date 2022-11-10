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
    <title>Mensaje de borrado</title>
</head>

<body class="bg-danger">
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
    <main>
        <c:if test="${empty deleteMessage}">
            <section class="text-center">
                <h1>¿Seguro que quieres borrar la figura?</h1>
                <form action="/delete" method="POST">
                    <input type="submit" value="SI">
                </form>
                <form action="/draw" method="GET">
                    <input type="submit" value="NO">
                </form>
            </section>
        </c:if>
           <h1 class="text-center">${deleteMessage}</h1>

    </main>
</body>
</html>