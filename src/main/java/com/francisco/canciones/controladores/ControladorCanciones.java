package com.francisco.canciones.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.francisco.canciones.modelos.Artista;
import com.francisco.canciones.modelos.Cancion;
import com.francisco.canciones.servicios.ServicioArtistas;
import com.francisco.canciones.servicios.ServicioCanciones;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class ControladorCanciones {

    private final ServicioArtistas servicioArtistas;
    @Autowired
    private final ServicioCanciones servicioCanciones;

    public ControladorCanciones(ServicioCanciones servicioCanciones, ServicioArtistas servicioArtistas){
        this.servicioCanciones = servicioCanciones;
        this.servicioArtistas = servicioArtistas;
    }
    @GetMapping("/")
    public String start(){
        return "index";
    }
    @GetMapping("/canciones")
    public String canciones(Model model){
        model.addAttribute("listaCanciones", servicioCanciones.obtenerTodasLasCanciones());
        return "canciones";
    }

    @GetMapping("/cancion/detalle/{idCancion}")
    public String desplegarDetalleCancion(@PathVariable Long idCancion, Model model){
        model.addAttribute("cancionPorId", servicioCanciones.obtenerCancionPorId(idCancion));
        return "detalleCancion";
    }

    @GetMapping("/canciones/formulario/agregar")
    public String formularioAgregarCanciones(@ModelAttribute("nuevaCancion") Cancion nuevaCancion,
                                            Model model){
                                                
        model.addAttribute("listaArtistas", this.servicioArtistas.obtenerTodosLosArtistas());
        return "agregarCancion";
    }
    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(@Valid @ModelAttribute("nuevaCancion") Cancion nuevaCancion,
                                        BindingResult validations,
                                        @RequestParam("idArtista") Long idArtista,
                                        Model model){
        if(validations.hasErrors()){
            model.addAttribute("listaArtistas", this.servicioArtistas.obtenerTodosLosArtistas());
            return "agregarCancion";
        }
        Artista artista = this.servicioArtistas.obtenerArtistaPorId(idArtista);
        nuevaCancion.setArtista(artista);
        this.servicioCanciones.agregarCancion(nuevaCancion);
        return "redirect:/canciones";
    } 

    @GetMapping("/canciones/formulario/editar/{idCancion}")
    public String formularioEditarCancion(@PathVariable Long idCancion,
                                          @ModelAttribute("cancion") Cancion cancion,
                                          Model model){
        Cancion cancionAEditar = this.servicioCanciones.obtenerCancionPorId(idCancion);
        model.addAttribute("cancion", cancionAEditar);
        return "editarCancion";
    }

    @PutMapping("/canciones/procesa/editar/{idCancion}")
    public String procesarEditarCancion(@Valid @ModelAttribute("cancion") Cancion cancion,
                                        BindingResult validations,
                                        @PathVariable("idCancion") Long idCancion){
        if(validations.hasErrors()){
            return "editarCancion";
        }
        cancion.setId(idCancion);
        this.servicioCanciones.actualizarCancion(cancion);
        return "redirect:/canciones";
    }

    @DeleteMapping("/canciones/eliminar/{idCancion}")
    public String procesarEliminarCancion(@PathVariable("idCancion") Long idCancion){
        this.servicioCanciones.eliminaCancion(idCancion);
        return "redirect:/canciones";
    }

}
