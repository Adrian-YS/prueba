package com.spring_app.crud_roles.Servicio;

import com.spring_app.crud_roles.Entidad.Alumno;
import com.spring_app.crud_roles.Repositorio.AlumnoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServicio {
    @Autowired
    AlumnoRepositorio alumnoRepositorio;

    public List<Alumno> getAlumno(){
        return alumnoRepositorio.findAll();
    }

    public Optional<Alumno> getAlumno(Long id){
        return alumnoRepositorio.findById(id);
    }

    public void guardar(Alumno alumno){
         alumnoRepositorio.save(alumno);
    }

    public void eliminar(Long id){
        alumnoRepositorio.deleteById(id);
    }
}
