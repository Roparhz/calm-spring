package com.project.calm.services;

import com.project.calm.dto.RecipeDTO;
import com.project.calm.entities.Recipe;
import com.project.calm.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> findAll(){ return recipeRepository.findAll();}
    public List<Recipe> findByName(String name){ return recipeRepository.findAllByNameContainingIgnoreCase(name);}
    public Recipe save(Recipe recipe) throws InstanceAlreadyExistsException{
        if(recipeRepository.existsRecipeByNameContainingIgnoreCase(recipe.getName())){
            throw new InstanceAlreadyExistsException("La recette existe déjà !");
        }
        return recipeRepository.save(recipe);
    }
    public Recipe update(RecipeDTO recipeDTO, Integer id) throws IllegalArgumentException{
        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);
        if(optionalRecipe.isPresent()){
            Recipe recipe = optionalRecipe.get();
            recipe.update(recipeDTO);
            return recipeRepository.save(recipe);
        }
        return null;
    }
    public Optional<Recipe> delete(Integer id) throws IllegalArgumentException{
        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);
        recipeRepository.deleteById(id);
        return optionalRecipe;
    }
}
