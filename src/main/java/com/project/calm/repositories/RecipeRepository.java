package com.project.calm.repositories;

import com.project.calm.entities.Recipe;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository  extends JpaRepository<Recipe, Integer> {
    List<Recipe> findAllByNameContainingIgnoreCase(String name);

    boolean existsRecipeByNameContainingIgnoreCase(String name);
}
