package com.spring_app.crud_roles.Repositorio;

import com.spring_app.crud_roles.Entidad.CredencialesUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredencialesUsuarioRepositorio extends JpaRepository <CredencialesUsuario, Long> {
    CredencialesUsuario findByUsername(String username);
}
