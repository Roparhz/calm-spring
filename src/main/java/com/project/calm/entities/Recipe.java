package com.project.calm.entities;


import com.project.calm.dto.RecipeDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Recipe")
@Getter
@Setter
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "price_coast")
    private Integer priceCoast;

    public Recipe(){}

    public Recipe(String name, Integer priceCoast){
        this.name = name;
        this.priceCoast = priceCoast;
    }

    public void update(RecipeDTO recipeDTO){
        this.name = recipeDTO.getName();
        this.priceCoast = recipeDTO.getPriceCoast();
    }
}
