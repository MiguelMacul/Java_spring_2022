package com.escuela.demo.Dao;

import java.util.List;

public interface PersonaModel {

    List<PersonaModel> getPersonas();


    void dropPersonas(Long id);

    void addPersonas(PersonaModel personaModel);

    void updatePersonas(PersonaModel personaModel);
}
