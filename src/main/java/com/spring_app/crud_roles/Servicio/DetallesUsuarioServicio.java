package com.spring_app.crud_roles.Servicio;

import com.spring_app.crud_roles.Entidad.CredencialesUsuario;
import com.spring_app.crud_roles.Entidad.Rol;
import com.spring_app.crud_roles.Repositorio.CredencialesUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetallesUsuarioServicio implements UserDetailsService {
    @Autowired
    private CredencialesUsuarioRepositorio credencialesUsuarioRepositorio;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CredencialesUsuario credencialesUsuario = credencialesUsuarioRepositorio.findByUsername(username);

        if (credencialesUsuario == null){
            throw new UsernameNotFoundException("USUARIO INCORRECTO" + username);
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Rol rol:credencialesUsuario.getRoles()){
            authorities.add(new SimpleGrantedAuthority(rol.getName()));
        }

        return new User(credencialesUsuario.getUsername(), credencialesUsuario.getPassword(), authorities);
    }
}
