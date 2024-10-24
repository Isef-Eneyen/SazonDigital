package com.example.sazondigital.Controllers;

import com.example.sazondigital.DTOs.IngredientDTO;
import com.example.sazondigital.Models.Ingredient;
import com.example.sazondigital.Services.IngredientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("ingredient")
public class IngredientController {

    private final IngredientService ingredientService;
    private static ObjectMapper MAPPER = new ObjectMapper();

    @GetMapping("")
    public ResponseEntity<?> GetAllIngredients() {
        List<Ingredient> ingredients = ingredientService.getAllIngredients();

        if (ingredients.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No hay ingredientes");
        }
        else {
            return ResponseEntity.ok(ingredients);
        }
    }

    @GetMapping("details/{id}")
    public ResponseEntity<?> GetIngredientById(@PathVariable int id) {
        Ingredient ingredient = ingredientService.getIngredientById(id);

        if (ingredient == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ingrediente no encontrado");
        }
        else {
            return ResponseEntity.ok(ingredient);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> CreateIngredient(@RequestBody String ingredient)throws JsonProcessingException {
        IngredientDTO dto = MAPPER.readValue(ingredient, IngredientDTO.class);

        Ingredient newIngredient = Ingredient.builder()
                .name(dto.getName())
                .category(dto.getCategory())
                .build();

        ingredientService.save(newIngredient);
        return ResponseEntity.status(HttpStatus.CREATED).body(newIngredient);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> UpdateIngredient(@PathVariable int id, @RequestBody String ingredient)throws JsonProcessingException {
        IngredientDTO dto = MAPPER.readValue(ingredient, IngredientDTO.class);
        Ingredient ingredientUpdate = ingredientService.getIngredientById(id);

        if (ingredientUpdate == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ingrediente no encontrado");
        }

        ingredientUpdate = Ingredient.builder()
                .id(id)
                .name(dto.getName())
                .category(dto.getCategory())
                .build();

        ingredientService.save(ingredientUpdate);
        return ResponseEntity.ok(ingredientUpdate);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteIngredient(@PathVariable int id) {
        Ingredient ingredient = ingredientService.getIngredientById(id);

        if (ingredient == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ingrediente no encontrado");
        }
        else {
            ingredientService.delete(ingredient);
            return ResponseEntity.ok().body(HttpStatus.ACCEPTED);
        }
    }
}
