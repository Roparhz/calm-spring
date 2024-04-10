package com.project.calm.services;

import com.project.calm.dto.IngredientDTO;
import com.project.calm.entities.Ingredient;
import com.project.calm.exceptions.EntityAlreadyCreatedException;
import com.project.calm.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    public List<Ingredient> getAllIngredient(){ return ingredientRepository.findAll();}
    public List<Ingredient> getIngredientByName(String name){ return ingredientRepository.findByNameContainingIgnoreCase(name);}
    public Ingredient save(Ingredient ingredient) throws EntityAlreadyCreatedException {
        if(ingredientRepository.existsByNameContainingIgnoreCase(ingredient.getName())){
            throw new EntityAlreadyCreatedException("L'ingrédient existe déjà !", "ingredient");
        }
        return ingredientRepository.save(ingredient);
    }
    public Ingredient update(IngredientDTO ingredientDTO, Integer id) throws IllegalArgumentException{
        Optional<Ingredient> optionalIngredient = ingredientRepository.findById(id);
        if(optionalIngredient.isPresent()){
            Ingredient ingredient =optionalIngredient.get();
            ingredient.updateIngredient(ingredientDTO);
            return ingredientRepository.save(ingredient);
        }
        return null;
    }
    public Optional<Ingredient> delete(Integer id) throws IllegalArgumentException{
        Optional<Ingredient> optionalIngredient = ingredientRepository.findById(id);
        ingredientRepository.deleteById(id);
        return optionalIngredient;
    }
}
