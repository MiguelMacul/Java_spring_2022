package com.escuela.demo.Dao;

import com.escuela.demo.model.AlumnoModel;
import com.escuela.demo.model.AlumnoRequestModel;
import com.escuela.demo.model.FacultadModel;
import com.escuela.demo.model.PersonaModel;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AlumnoDao {

    List<AlumnoRequestModel> getAlumnos();

    void dropAlumnos(String curp);

    AlumnoRequestModel getPersonaById(String curp);

    void addAlumnos(AlumnoRequestModel alumnoRequestModel);

    void updateAlumnos( AlumnoRequestModel alumnoRequestModel);

    List<FacultadModel> getAlumnosFacultad(String facuiltad);

}
