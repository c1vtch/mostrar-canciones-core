package com.francisco.canciones.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francisco.canciones.modelos.Artista;
import com.francisco.canciones.repositorios.RepositorioArtistas;

@Service
public class ServicioArtistas {
    @Autowired
    private final RepositorioArtistas repositorioArtistas;

    public ServicioArtistas(RepositorioArtistas repositorioArtistas){
        this.repositorioArtistas = repositorioArtistas;
    }

    public List<Artista> obtenerTodosLosArtistas(){
        return this.repositorioArtistas.findAll();
    }

    public Artista obtenerArtistaPorId(Long id){
        return this.repositorioArtistas.findById(id).orElse(null);
    }

    public Artista agregarArtista(Artista artista){
        return this.repositorioArtistas.save(artista);
    }
}
