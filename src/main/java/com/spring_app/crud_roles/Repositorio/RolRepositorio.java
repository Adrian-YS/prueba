package com.spring_app.crud_roles.Repositorio;

import com.spring_app.crud_roles.Entidad.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepositorio extends JpaRepository <Rol, Long> {
    Rol findByName(String name);
}
