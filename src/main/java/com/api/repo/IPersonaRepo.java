package com.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.model.Persona;

public interface IPersonaRepo extends JpaRepository<Persona, Integer>{

    @Query(nativeQuery = false,value = " SELECT c FROM Persona c WHERE Email = ?1")
    Persona findPersonaByEmail(String doc);
}
