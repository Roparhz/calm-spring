package com.project.calm.entities;


import com.project.calm.dto.IngredientDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Ingredient")
@Getter
@Setter
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "price_per_unit")
    private Integer pricePerUnit;
    @Column(name = "unit")
    private String unit;


    public Ingredient(){}

    public Ingredient(String name, Integer price_per_unit, String unit){
        this.name = name;
        this.pricePerUnit = price_per_unit;
        this.unit = unit;
    }

    public void updateIngredient(IngredientDTO ingredientDTO){
        this.setName(ingredientDTO.getName());
        this.setPricePerUnit(ingredientDTO.getPricePerUnit());
        this.setUnit(ingredientDTO.getUnit());
    }
}
