package com.francisco.canciones.modelos;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="canciones")
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=5, message="El titulo debe tener al menos 5 caracteres")
    String titulo;

    @ManyToOne
    @JoinColumn(name = "id_artista")
    private Artista artista;

    @Size(min=3, message="Album debe tener al menos 3 caracteres" )
    String album;

    @Size(min=3, message="Genero debe tener al menos 3 caracteres" )
    String genero;

    @Size(min=3, message="Idioma debe tener al menos 3 caracteres" )
    String idioma;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name ="fecha_creacion")
    private Date fecha_creacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name ="fecha_actualizacion")
    private Date fecha_actualizacion;

    public Cancion(){}

    @PrePersist
    protected void onCreate(){
        this.fecha_creacion = new Date();
        this.fecha_actualizacion = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.fecha_actualizacion = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(Date fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }

    
}
