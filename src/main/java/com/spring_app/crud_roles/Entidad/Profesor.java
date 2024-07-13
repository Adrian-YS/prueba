package com.spring_app.crud_roles.Entidad;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@Entity
@Data
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.MERGE)
    private List<Asignatura> asignaturas;
}
