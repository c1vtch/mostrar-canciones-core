package com.francisco.canciones.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.francisco.canciones.modelos.Cancion;
import com.francisco.canciones.servicios.ServicioCanciones;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class ControladorCanciones {
    @Autowired
    private final ServicioCanciones servicioCanciones;

    public ControladorCanciones(ServicioCanciones servicioCanciones){
        this.servicioCanciones = servicioCanciones;
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
    public String formularioAgregarCanciones(@ModelAttribute("nuevaCancion") Cancion nuevaCancion){
        return "agregarCancion";
    }
    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(@Valid @ModelAttribute("nuevaCancion") Cancion nuevaCancion,
                                        BindingResult validations){
        if(validations.hasErrors()){
            return "agregarCancion";
        }
        this.servicioCanciones.agregarCancion(nuevaCancion);
        return "redirect:/canciones";
    } 

}
