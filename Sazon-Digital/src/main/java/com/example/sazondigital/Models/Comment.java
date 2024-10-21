package com.example.sazondigital.Models;

import jakarta.persistence.*;
import lombok.*;
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

    private String content;
    private int rating;

    @Temporal(TemporalType.DATE)
    private Date commentDate;
}
