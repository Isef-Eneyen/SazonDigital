package com.example.sazondigital.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull(message = "No puede ser nulo")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String name;

    @NotNull(message = "No puede ser nulo")
    @Email(message = "Email inválido")
    @Column(unique = true)
    private String email;

    @NotNull(message = "No puede ser nulo")
    @Min(value = 8, message = "La contraseña debe de tener mínimo 8 caracteres")
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
