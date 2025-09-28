<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detalle Cancion</title>
</head>
<body>
    <h1>Detalles de Artista</h1>
    <p><b>ID: </b>${artistaDetalle.id}</p>
    <p><b>Nombre:</b> ${artistaDetalle.nombre}</p>
    <p><b>Apellido:</b> ${artistaDetalle.apellido}</p>
    <p><b>Biografia: </b>${artistaDetalle.biografia}</p><br>
    <h4>Canciones de este artista</h4>
    <ul>
        <c:forEach var="canciones" items="${cancionesArtista}">
            <li>${canciones.titulo}</li>
        </c:forEach>
    </ul>
    <a href="/artistas">Volver a lista de artistas</a>
</body>
</html>