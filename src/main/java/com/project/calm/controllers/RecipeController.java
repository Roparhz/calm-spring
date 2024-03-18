package com.project.calm.controllers;

import com.project.calm.dto.RecipeDTO;
import com.project.calm.entities.Recipe;
import com.project.calm.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceAlreadyExistsException;
import java.util.List;

@RestController
@RequestMapping("/api/recipe")

public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping("/all")
    public List<Recipe> getAllRecipe() { return recipeService.findAll(); }

    @GetMapping("/name")
    public List<Recipe> getByName(@RequestParam String name) { return recipeService.findByName(name); }

    @PostMapping("/add")
    public Recipe addRecipe(@RequestBody RecipeDTO recipeDTO) throws InstanceAlreadyExistsException{
        return recipeService.save(recipeDTO.toRecipe());
    }

    @PutMapping("/update/{id}")
    public Recipe updateRecipe(@RequestBody RecipeDTO recipeDTO, @PathVariable Integer id){
        return recipeService.update(recipeDTO, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRecipe(@PathVariable Integer id){ recipeService.delete(id);}
}
