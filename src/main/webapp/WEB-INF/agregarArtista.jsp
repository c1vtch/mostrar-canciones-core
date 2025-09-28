<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/styles.css">
    <title>Agregar Artista</title>
</head>
<body>
    <h3>Agregar cancion</h3>
    <form:form action="/artistas/procesa/agregar" method="POST" modelAttribute="nuevoArtista">
        <div>
            <form:label path="nombre">Nombre: </form:label> <br>
            <form:input path="nombre"/>
            <form:errors path="nombre"/>
        </div>
        <div>
            <form:label path="apellido">Apellido: </form:label> <br>
            <form:input path="apellido"/>
            <form:errors path="apellido"/>
        </div>
        <div>
            <form:label path="biografia">Biografia: </form:label> <br>
            <form:input path="biografia"/>
            <form:errors path="biografia"/>
        </div>
        
        <br>
        <button>
            Agregar
        </button>        
        <a href="/artistas">volver a canciones</a>
    </form:form>
</body>
</html>