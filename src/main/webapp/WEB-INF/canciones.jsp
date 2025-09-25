<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/styles.css">
    <title>Canciones</title>
</head>
<body>
    <h1>Lista de canciones</h1>
    <table>
        <tr>
            <th>Titulo</th>
            <th>Autor</th>
            <th>Detalles</th>
        </tr>
        <c:forEach var="cancion" items="${listaCanciones}">
            <tr>
                <td>${cancion.titulo}</td>
                <td>${cancion.artista}</td>
                <td><a href="/cancion/detalle/${cancion.id}">detalles</a></td>
            </tr>
        </c:forEach>
        
    </table>
     <br>
    <a href="/canciones/formulario/agregar">Agregar cancion</a>

</body>
</html>