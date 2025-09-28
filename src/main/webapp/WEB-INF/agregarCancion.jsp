<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/styles.css">
    <title>Agregar Cancion</title>
</head>
<body>
    <h3>Agregar cancion</h3>
    <form:form action="/canciones/procesa/agregar" method="POST" modelAttribute="nuevaCancion">
        <div>
            <form:label path="titulo">Titulo: </form:label> <br>
            <form:input path="titulo"/>
            <form:errors path="titulo"/>
        </div>
        <div>
            <form:label path="artista">Artista: </form:label> <br>
            <select name="idArtista" id="idArtista">
                <option value="">--Selecciona un artista--</option>
                <c:forEach var="artista" items="${listaArtistas}">
                    <option value="${artista.id}">${artista.nombre} ${artista.apellido}</option>
                </c:forEach>
            </select>
            <form:errors path="artista"/>
        </div>
        <div>
            <form:label path="album">Album: </form:label> <br>
            <form:input path="album"/>
            <form:errors path="album"/>
        </div>
        <div>
            <form:label path="genero">Genero: </form:label> <br>
            <form:input path="genero"/>
            <form:errors path="genero"/>
        </div>
        <div>
            <form:label path="idioma">Idioma: </form:label> <br>
            <form:input path="idioma"/>
            <form:errors path="idioma"/>
        </div>
        <br>
        <button>
            Agregar
        </button>        
        <a href="/canciones">volver a canciones</a>
    </form:form>
</body>
</html>