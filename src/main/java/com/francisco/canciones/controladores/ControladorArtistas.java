package com.francisco.canciones.controladores;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.francisco.canciones.modelos.Artista;
import com.francisco.canciones.modelos.Cancion;

import com.francisco.canciones.servicios.ServicioArtistas;
import com.francisco.canciones.servicios.ServicioCanciones;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class ControladorArtistas {
    @Autowired
    private final ServicioCanciones servicioCanciones;
    @Autowired
    private final ServicioArtistas servicioArtistas;
    public ControladorArtistas(ServicioArtistas servicioArtistas, ServicioCanciones servicioCanciones){
        this.servicioArtistas = servicioArtistas;
        this.servicioCanciones = servicioCanciones;
    }
    @GetMapping("/artistas")
    public String desplegarArtistas(Model model){
        model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
        return "artistas";
    }
    @GetMapping("/artistas/detalle/{idArtista}")
    public String desplegarDetalleArtista(@PathVariable("idArtista") Long idArtista,
                                          Model model){
        List<Cancion> cancionesArtista = servicioCanciones.findByArtistaId(idArtista);
        model.addAttribute("artistaDetalle" , servicioArtistas.obtenerArtistaPorId(idArtista));
        model.addAttribute("cancionesArtista", cancionesArtista);
        return "detallesArtista";
    }

    @GetMapping("/artistas/formulario/agregar")
    public String formularioAgregarArtista(@ModelAttribute("nuevoArtista") Artista nuevoArtista){
        return "agregarArtista";
    }

    @PostMapping("/artistas/procesa/agregar")
    public String postMethodName(@Valid @ModelAttribute("nuevoArtista") Artista nuevoArtista,
                                BindingResult validations) {
        if(validations.hasErrors()){
            return "agregarArtista";
        }
        this.servicioArtistas.agregarArtista(nuevoArtista);
        return "redirect:/artistas";
    }
    
}
