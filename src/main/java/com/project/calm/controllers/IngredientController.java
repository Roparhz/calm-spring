package com.project.calm.controllers;

import com.project.calm.dto.IngredientDTO;
import com.project.calm.entities.Ingredient;
import com.project.calm.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceAlreadyExistsException;
import java.util.List;

@RestController
@RequestMapping("/api/ingredient")

public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    @GetMapping("/all")
    public List<Ingredient> getAllIngredients() { return ingredientService.getAllIngredient(); }

    @GetMapping("/name")
    public List<Ingredient> getByName (@RequestParam String name) { return ingredientService.getIngredientByName(name); }

    @PostMapping("/add")
    public Ingredient addIngredient(@RequestBody IngredientDTO ingredientDTO) throws InstanceAlreadyExistsException {
        return ingredientService.save(ingredientDTO.toIngredient());
    }

    @PutMapping("/update/{id}")
    public Ingredient updateIngredient(@RequestBody IngredientDTO ingredientDTO, Integer id){
        return ingredientService.update(ingredientDTO, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteIngredient(@PathVariable Integer id) { ingredientService.delete(id); }
}
