package com.example.sazondigital.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "No puede ser nulo")
    @Size(min = 2, max =100, message = "El nombre del ingrediente debde tener entre 2 y 100 caracteres")
    private String name;

    @NotNull(message = "No puede ser nulo")
    @Size(min = 2,max = 50,message = "La categoria tiene que tener entre 2 y 50 caracteres")
    private String category;

    @JsonIgnore
    @ManyToMany(mappedBy = "ingredients")
    private List<Recipe> recipes;
}
