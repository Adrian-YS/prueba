package com.spring_app.crud_roles.Repositorio;

import com.spring_app.crud_roles.Entidad.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepositorio extends JpaRepository <Alumno, Long> {

}
