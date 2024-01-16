package com.project.calm.repositories;

import com.project.calm.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    List<Ingredient> findByNameContainingIgnoreCase(String name);
    boolean existsByNameContainingIgnoreCase( String name);
}
