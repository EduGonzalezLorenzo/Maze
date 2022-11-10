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
    <title>Mi Perfil</title>
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
        <article id="allFig" class="row justify-content-center">
            <h1 class="text-center">Perfil de ${currentUser.name}</h1>
            <div class="row justify-content-between">                
                <form class="col-6" action="/profile" method="POST">
                    <label for="nameSearch">Busqueda por nombre:</label>
                    <input type="text" id="nameSearch" name="nameSearch">
                    <input type="submit" value="Buscar">    
                </form>
                <form class="col-4" action="/logout" method="POST">
                    <input type="submit" value="Cerrar sesión">    
                </form>
            </div>
           
            <table class="bg-white">
                <tr style="margin-bottom:10px; border: 1px solid black;">
                    <th style="margin-bottom:10px; border: 1px solid black;">Nombre de usuario</th>
                    <th style="margin-bottom:10px; border: 1px solid black;">Nombre de la figura</th>
                    <th style="margin-bottom:10px; border: 1px solid black;">Tipo de figura</th>
                    <th style="margin-bottom:10px; border: 1px solid black;">Fecha de creación</th>
                    <th style="margin-bottom:10px; border: 1px solid black;">Mostrar figura</th>
                    <th style="margin-bottom:10px; border: 1px solid black;">Borrar figura</th>
                </tr>
                <c:forEach var="figure" items="${figures}">
                        <tr style="margin-bottom:10px; border: 1px solid black;">
                            <td style="margin-bottom:10px; border: 1px solid black;">${figure.user.name}</td>
                            <td style="margin-bottom:10px; border: 1px solid black;">${figure.name}</td>
                            <td style="margin-bottom:10px; border: 1px solid black;">${figure.shape}</td>
                            <td style="margin-bottom:10px; border: 1px solid black;">${figure.creationDate}</td>
                            <td style="margin-bottom:10px; border: 1px solid black;">
                                <form action="/view" method="POST">
                                    <input type="hidden" name="fid" id="fid" value=${figure.id}>
                                    <input type="submit" value="Ver dibujo">
                                </form>
                            </td>
                            <td style="margin-bottom:10px; border: 1px solid black;">
                                <form action="/delete" method="GET">
                                    <input type="hidden" name="fid" id="fid" value=${figure.id}>
                                    <input type="submit" value="Borrar dibujo">
                                </form>
                            </td>
                        </tr>
                </c:forEach>
            </table>
        </article>
    </main>
    <script>

    </script>
</body>

</html>