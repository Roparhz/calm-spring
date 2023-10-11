package com.project.calm.dto;


import com.project.calm.entities.Recipe;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipeDTO {
    private String name;
    private Integer priceCoast;

    public RecipeDTO(){}

    public RecipeDTO(String name, Integer priceCoast){
        this.name = name;
        this.priceCoast = priceCoast;
    }

    public Recipe toRecipe(){
        Recipe recipe = new Recipe();
        recipe.setName(this.getName());
        recipe.setPriceCoast(this.getPriceCoast());
        return recipe;
    }
}
