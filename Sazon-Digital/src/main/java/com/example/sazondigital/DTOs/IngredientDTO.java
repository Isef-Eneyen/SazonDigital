package com.example.sazondigital.DTOs;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IngredientDTO {

    @NotNull(message = "No puede ser nulo")
    @Size(min = 2, max = 100, message = "El nombre del ingrediente debe tener entre 2 y 100 caracteres")
    private String name;

    @NotNull(message = "No puede ser nulo")
    @Size(min = 2, max = 50, message = "La categoría debe tener entre 2 y 50 caracteres")
    private String category;
}