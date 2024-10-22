package com.example.sazondigital.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Range;

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

    @NotNull(message = "No puede ser nulo")
    @Size(min = 5,max = 100, message = "El título debe tener entre 5 y 100 caracteres")
    private String title;

    @Size(max = 500, message = "La descripción no puede tener mas de 500 caracteres")
    private String description;

    @ManyToOne
    @JoinColumn(name = "idAuthor") // Relación muchos a uno (autor)
    private User author;

    @NotNull(message = "No puede ser nulo")
    private String instructions;

    @NotNull(message = "No puede ser nulo")
    private String category;

    @NotNull(message = "No puede ser nulo")
    @Min(value = 1,message = "El tiempo de preparación debe ser de al menos 1 min")
    private int preparationTime;

    @NotNull(message = "No puede ser nulo")
    @Range(min = 1, max = 5, message = "La dificultad debe de estar entre 1 y 5")
    private int difficulty;

    @NotNull(message = "No puede ser nulo")
    @DecimalMin(value = "0.0", inclusive = false, message = "Las calorias tienen que ser mayores a 0")
    private double calories;

    @NotNull(message = "No puede ser nulo")
    @Range(min = 1, max = 5, message = "La valoración debe de estar entre 1 y 5")
    private int rating;

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
