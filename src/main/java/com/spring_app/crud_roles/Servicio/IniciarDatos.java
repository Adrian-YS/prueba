package com.spring_app.crud_roles.Servicio;

import com.spring_app.crud_roles.Entidad.CredencialesUsuario;
import com.spring_app.crud_roles.Entidad.Rol;
import com.spring_app.crud_roles.Repositorio.CredencialesUsuarioRepositorio;
import com.spring_app.crud_roles.Repositorio.RolRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IniciarDatos {
    @Autowired
    private CredencialesUsuarioRepositorio credencialesUsuarioRepositorio;

    @Autowired
    private RolRepositorio rolRepositorio;

    @Bean
    public CommandLineRunner init(){
        return args -> {
            Rol adminRole = new Rol();
            adminRole.setName("ROLE_ADMIN");
            rolRepositorio.save(adminRole);

            Rol userRole = new Rol();
            userRole.setName("ROLE_USER");
            rolRepositorio.save(userRole);

            CredencialesUsuario admin = new CredencialesUsuario();
            admin.setUsername("ADRYS1");
            admin.setPassword("adrian2003ana1");

            List<Rol> adminRoles = new ArrayList<>();
            adminRoles.add(adminRole);
            admin.setRoles(adminRoles);
            credencialesUsuarioRepositorio.save(admin);

            CredencialesUsuario user = new CredencialesUsuario();
            user.setUsername("ADRYS2");
            user.setPassword("adrian2003ana2");

            List<Rol> userRoles = new ArrayList<>();
            userRoles.add(userRole);
            user.setRoles(userRoles);
            credencialesUsuarioRepositorio.save(user);
        };
    }
}
