package com.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.model.Curso;

@Repository
public interface ICursoRepo extends JpaRepository<Curso, Integer>{


}
