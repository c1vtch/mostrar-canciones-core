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
    <h1>Detalles de cancion ${cancionPorId.titulo}</h1>
    <p><b>ID: </b>${cancionPorId.id}</p>
    <p><b>Artista: </b>${cancionPorId.artista.nombre} ${cancionPorId.artista.apellido}</p>
    <p><b>Album: </b>${cancionPorId.album}</p>
    <p><b>Genero: </b>${cancionPorId.genero}</p>
    <p><b>Idioma: </b>${cancionPorId.idioma}</p>
    <a href="/canciones">Volver a canciones</a>
    <a href="/canciones/formulario/editar/${cancionPorId.id}"><button>Editar detalles</button></a>
    
    <form action="/canciones/eliminar/${cancionPorId.id}" method="POST"> <br>
        <input type="hidden" name="_method" value="DELETE">
        <button>
            eliminar cancion
        </button>
    </form>
</body>
</html>