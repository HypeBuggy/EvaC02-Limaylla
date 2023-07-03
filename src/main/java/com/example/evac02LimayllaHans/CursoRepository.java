package com.example.evac02LimayllaHans;

import org.springframework.data.repository.CrudRepository;

import com.example.evac02LimayllaHans.Curso;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CursoRepository extends CrudRepository<Curso, Integer> {

}
