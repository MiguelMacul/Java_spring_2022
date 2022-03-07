package com.escuela.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "personas")
@ToString
public class PersonaModel {

    @Id
    @Getter @Setter @Column(name = "idpersona")
    private int idpersona;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @Getter @Setter @Column(name = "primerapellido")
    private String primerapellido;

    @Getter @Setter @Column(name = "segundoapellido")
    private String segundoapellido;

    @Getter @Setter @Column(name = "fechanacimiento")
    private String fechanacimiento;

    @Getter @Setter @Column(name = "curp")
    private String curp;

    @Getter @Setter @Column(name = "genero")
    private String genero;

    @Getter @Setter @Column(name = "ciudadnacimiento")
    private String ciudadnacimiento;

}
