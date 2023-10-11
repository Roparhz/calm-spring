package com.project.calm.dto;


import com.project.calm.entities.RecipeRelation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipeRelationDTO {
    private Integer ingredientId;
    private Integer recipeId;
    private Integer quantity;

    public RecipeRelationDTO(){}

    public RecipeRelationDTO(Integer ingredientId, Integer recipeId, Integer quantity){
        this.ingredientId = ingredientId;
        this.recipeId = recipeId;
        this.quantity = quantity;
    }

    public RecipeRelation toRecipeRelation(){
        RecipeRelation recipeRelation =new RecipeRelation();
        recipeRelation.setRecipeId(this.getRecipeId());
        recipeRelation.setIngredientId(this.getIngredientId());
        recipeRelation.setQuantity(this.getQuantity());
        return recipeRelation;
    }
}
