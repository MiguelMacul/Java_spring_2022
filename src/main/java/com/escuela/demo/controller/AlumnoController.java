package com.escuela.demo.controller;

import com.escuela.demo.Dao.AlumnoDao;
import com.escuela.demo.model.AlumnoModel;
import com.escuela.demo.model.AlumnoRequestModel;
import com.escuela.demo.model.FacultadModel;
import com.escuela.demo.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class AlumnoController {

    @Autowired
    private AlumnoDao alumnoDao;

    @RequestMapping(value = "alumnos" ,method = RequestMethod.GET)
    public List<AlumnoRequestModel> getAlumno(){
       return this.alumnoDao.getAlumnos();
    }

    @RequestMapping(value = "alumnos" ,method = RequestMethod.POST)
    public ResponseModel postAlumno(@RequestBody AlumnoRequestModel alumnoRequestModel){
        this.alumnoDao.addAlumnos(alumnoRequestModel);
        return new ResponseModel(200, "Exito en la insersion", "Alumno correctamente registrado");
    }

    @RequestMapping(value = "alumnos" ,method = RequestMethod.DELETE)
    public ResponseModel postAlumno(@PathParam("curp") String curp){
        this.alumnoDao.dropAlumnos(curp);
        return new ResponseModel(200, "Exito se elimino", "Alumno correctamente eliminado");
    }

    @RequestMapping(value = "alumnos/{curp}" ,method = RequestMethod.GET)
    public AlumnoRequestModel getAlumnoByIdApi(@PathVariable String curp){
        return this.alumnoDao.getPersonaById(curp);
    }

    @RequestMapping(value = "alumnos" ,method = RequestMethod.PUT)
    public ResponseModel updateAlumno(@RequestBody AlumnoRequestModel alumnoRequestModel ){
        this.alumnoDao.updateAlumnos( alumnoRequestModel);
        return new ResponseModel(200, "Exito actualizado", "Alumno correctamente actualizado");
    }

    @RequestMapping(value = "alumnos/facultad" ,method = RequestMethod.GET)
    public List<FacultadModel> getAlumnos(@PathParam("facultad")  String facultad){
        return this.alumnoDao.getAlumnosFacultad(facultad);
    }
}
