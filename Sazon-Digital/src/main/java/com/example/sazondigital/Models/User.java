package com.example.sazondigital.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Data // Genera automáticamente getters, setters, toString, equals, hashCode
@NoArgsConstructor // Constructor sin argumentos
@AllArgsConstructor // Constructor con todos los argumentos
@Builder // Permite usar el patrón builder para construir instancias de User
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @Temporal(TemporalType.DATE)
    private Date registerDate;

    @JsonIgnore
    @OneToMany(mappedBy = "author")
    private List<Recipe> createdRecipes;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "user_favorite_recipes", // Tabla intermedia entre usuarios y recetas
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )
    private List<Recipe> favoriteRecipes;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "UserRol", // Tabla intermedia entre Usuarios y Roles
            joinColumns = @JoinColumn(name = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "idRol")
    )
    private List<Rol> rols;
}
