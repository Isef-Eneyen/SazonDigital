package com.example.sazondigital.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "idAuthor") // Relación muchos a uno (autor)
    private User author;

    private String instructions;
    private String category;
    private int preparationTime;
    private int difficulty;
    private double calories;
    private double rating;

    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @OneToMany(mappedBy = "recipe")
    private List<Comment> comments; // Relación uno a muchos con los comentarios

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "recipe_ingredients", // Tabla intermedia para la relación muchos a muchos con Ingredientes
            joinColumns = @JoinColumn(name = "idRecipe"),
            inverseJoinColumns = @JoinColumn(name = "idIngredient")
    )
    private List<Ingredient> ingredients;

    @JsonIgnore
    @ManyToMany(mappedBy = "favoriteRecipes")
    private List<User> users;

}
