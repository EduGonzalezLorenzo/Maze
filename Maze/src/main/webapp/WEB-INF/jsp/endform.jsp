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
    <title>Inicio de sesión</title>
</head>

<body class="text-center bg-primary container">
    <h1>Formulario de victoria</h1>
    <article class="bg-light row justify-content-center">
        <form  action="/endform" method="POST">
        <label for="playerName">Introduzca tu nombre de usuario para registrar tu victoria:</label>
        <input type="text" name="playerName" id="playerName">
        <input type="submit" value="Enviar">
        <c:if test ="${not empty logError}">
        <p class="bg-light text-danger"> Error: ${logError}. </p>
    </c:if>
    </form>
    </article>
</body>
</html>