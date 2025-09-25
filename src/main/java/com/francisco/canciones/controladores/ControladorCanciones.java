package com.francisco.canciones.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.francisco.canciones.servicios.ServicioCanciones;

import org.springframework.ui.Model;

@Controller
public class ControladorCanciones {
    @Autowired
    private final ServicioCanciones servicioCanciones;

    public ControladorCanciones(ServicioCanciones servicioCanciones){
        this.servicioCanciones = servicioCanciones;
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
}
