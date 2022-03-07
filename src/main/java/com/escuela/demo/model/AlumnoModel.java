package com.escuela.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "alumnos")
@AllArgsConstructor
@ToString
public class AlumnoModel {
    @Id
    @Getter @Setter @Column (name = "idalumno")
    private int idalumno;

    @Getter @Setter @Column (name = "periodoingreso")
    private String periodoingreso;

    @Getter @Setter @Column (name = "licenciatura")
    private String licenciatura;

    @Getter @Setter @Column (name = "matricula")
    private String matricula;


   @Getter @Setter @Column (name = "idpersona")
    private int idpersona;


    public AlumnoModel() {

    }
}
