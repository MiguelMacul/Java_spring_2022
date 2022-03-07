package com.escuela.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@ToString
public class AlumnoRequestModel {

    @Setter @Getter
    private PersonaModel personaModel;
    @Setter @Getter
    private List<AlumnoModel> alumnoModel;
}
