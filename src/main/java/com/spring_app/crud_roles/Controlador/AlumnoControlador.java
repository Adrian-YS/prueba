package com.spring_app.crud_roles.Controlador;

import com.spring_app.crud_roles.Entidad.Alumno;
import com.spring_app.crud_roles.Servicio.AlumnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class AlumnoControlador {
    @Autowired
    private AlumnoServicio alumnoServicio;

    //LEER
    @GetMapping("/alumnos")
    public String mostrarAlumno(Model model){
        List<Alumno> alumnos = alumnoServicio.getAlumno();
        model.addAttribute("alumnos", alumnos);
        return "/alumno/vw_alumno";
    }

    //CREAR
    @GetMapping("/alumno/formulario")
    public String formulario(Model model){
        model.addAttribute("alumno", new Alumno());
        return "/alumno/formulario";
    }

    @PostMapping("/alumno/guardar")
    public String guarda(Alumno alumno){
        alumnoServicio.guardar(alumno);
        return "redirect:/alumnos";
    }

    //Actualizar
    @GetMapping("/alumno/editar/{alumnoId}")
    public String actualiza(@PathVariable Long alumnoId, Model model){
        Optional<Alumno> alumno = alumnoServicio.getAlumno(alumnoId);
        model.addAttribute("alumno", alumno);
        return "alumno/formulario";
    }

    //ELIMINAR
    @GetMapping("/alumno/eliminar/{alumnoId}")
    public String elimina(@PathVariable("alumnoId") Long alumnoId)
    {
        alumnoServicio.eliminar(alumnoId);
        return "redirect:/alumnos";
    }
}
