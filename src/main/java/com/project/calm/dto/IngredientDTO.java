package com.project.calm.dto;


import com.project.calm.entities.Ingredient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientDTO {
    private String name;
    private Integer pricePerunit;
    private String unit;

    public IngredientDTO(){}

    public IngredientDTO(String name, Integer pricePerunit, String unit){
        this.name = name;
        this.pricePerunit = pricePerunit;
        this.unit = unit;
    }

    public Ingredient toIngredient(){
        Ingredient ingredient = new Ingredient();
        ingredient.setName(this.getName());
        ingredient.setPricePerUnit(this.getPricePerunit());
        ingredient.setUnit(this.getUnit());
        return ingredient;
    }
}
