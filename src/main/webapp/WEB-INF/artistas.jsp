<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/styles.css">
    <title>Artistas</title>
</head>
<body>
    <h1>Lista de artistas</h1>
    <ul>
        <c:forEach var="artista" items="${artistas}">
            <a href="/artistas/detalle/${artista.id}"><li>${artista.nombre} ${artista.apellido}</li></a>
        </c:forEach>
    </ul>
    <a href="/canciones">ir a canciones</a>
    <a href="/artistas/formulario/agregar">agregar artista</a>
</body>
</html>