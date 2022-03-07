package com.escuela.demo.Dao;

import com.escuela.demo.model.AlumnoModel;
import com.escuela.demo.model.AlumnoRequestModel;
import com.escuela.demo.model.FacultadModel;
import com.escuela.demo.model.PersonaModel;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class AlumnoDaoImp implements AlumnoDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<AlumnoRequestModel> getAlumnos() {
        String query = "FROM PersonaModel";
        List<AlumnoRequestModel> list=new ArrayList<AlumnoRequestModel>();
        int i=0;
        for(Object persona: entityManager.createQuery(query).getResultList()){
            AlumnoRequestModel nodo=new AlumnoRequestModel();
            nodo.setPersonaModel((PersonaModel) persona);
           String query2 = "FROM  AlumnoModel WHERE idpersona = '"+((PersonaModel) persona).getIdpersona()+"'";
           Query queriman= entityManager.createQuery(query2);
             nodo.setAlumnoModel(queriman.getResultList());
            list.add(nodo);
            i++;
        }
        return list ;
    }

    @Override
    public void dropAlumnos(String curp) {
        List<PersonaModel> persona= entityManager.createQuery("FROM PersonaModel WHERE curp='"+curp.toString()+"'").getResultList();
        entityManager.remove(persona.get(0));
    }

    @Override
    public AlumnoRequestModel getPersonaById(String curp) {
        List<PersonaModel> persona= entityManager.createQuery("FROM PersonaModel WHERE curp='"+curp.toString()+"'").getResultList();
        AlumnoRequestModel requestModel= new AlumnoRequestModel();
        requestModel.setPersonaModel(persona.get(0));
        List<AlumnoModel> alumno= entityManager.createQuery("FROM AlumnoModel WHERE idpersona='"+persona.get(0).getIdpersona()+"'").getResultList();
        requestModel.setAlumnoModel(alumno);
        return requestModel;
    }

    @Override
    @Transactional(readOnly = false)
    public void addAlumnos(AlumnoRequestModel alumnoRequestModel) {
        entityManager.merge(alumnoRequestModel.getPersonaModel());
        List<PersonaModel> alumno= entityManager.createQuery("FROM PersonaModel WHERE curp='"+alumnoRequestModel.getPersonaModel().getCurp().toString()+"'").getResultList();
        int i=0;
        for(AlumnoModel a:  alumnoRequestModel.getAlumnoModel()){
            alumnoRequestModel.getAlumnoModel().get(i).setIdpersona(alumno.get(0).getIdpersona());
            entityManager.merge(alumnoRequestModel.getAlumnoModel().get(i));
            i++;
        }
    }

    @Override
    public void updateAlumnos(AlumnoRequestModel alumnoRequestModel) {
        entityManager.merge(alumnoRequestModel.getPersonaModel());
        for(AlumnoModel alumno: alumnoRequestModel.getAlumnoModel()){
            entityManager.merge(alumno);
        }
    }

    @Override
    public List<FacultadModel> getAlumnosFacultad(String facuiltad) {
        List<FacultadModel> facultades=entityManager.createQuery("SELECT nombre, cantidad from FacultadModel").getResultList();
        return facultades;
    }


}
