package com.project.calm.entities;


import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Recipe_relation")
@Getter
@Setter
public class RecipeRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "recipe_id", updatable = false, insertable = false)
    private Recipe recipe;
    @Column(name = "recipe_id")
    private Integer recipeId;

    @ManyToOne
    @JoinColumn(name = "ingredient_id", updatable = false, insertable = false)
    private Ingredient ingredient;
    @Column(name = "ingredient_id")
    private Integer ingredientId;

    @Column(name = "quantity")
    private Integer quantity;

    public RecipeRelation() {}

}
