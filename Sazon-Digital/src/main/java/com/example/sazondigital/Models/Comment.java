package com.example.sazondigital.Models;

import jakarta.persistence.*;
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
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idUser") // Comentario hecho por un usuario
    private User user;

    @ManyToOne
    @JoinColumn(name = "idRecipe") // Comentario asociado a una receta
    private Recipe recipe;

    @NotNull(message = "No puede ser nulo")
    @Size(min = 3, max = 500, message = "El comentario debe tener entre 3 y 500 caracteres")
    private String content;

    @NotNull(message = "No puede ser nulo")
    @Range(min = 1, max = 5)
    private int rating;

    @Temporal(TemporalType.DATE)
    private Date commentDate;
}
