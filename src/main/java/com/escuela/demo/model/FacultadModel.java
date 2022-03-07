package com.escuela.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.data.repository.query.Param;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ToString
@Entity
@Table(name = "alumnos_licenciatura_view")
public class FacultadModel {
    @Id
    @Column(name = "id", nullable = true)
    @Getter @Setter
    private Long id;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @Getter @Setter @Column(name = "cantidad")
    private int cantidad;


}
