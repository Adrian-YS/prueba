package com.spring_app.crud_roles.Entidad;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
@Data
@Entity
@Table(name = "alumnos")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long alumnoId;
    private String nombre;
    private String apellido;

    @Column(unique = true, nullable = false)
    private String email;
}
