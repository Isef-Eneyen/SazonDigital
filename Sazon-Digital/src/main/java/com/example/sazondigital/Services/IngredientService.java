package com.example.sazondigital.Services;

import com.example.sazondigital.Models.Ingredient;
import com.example.sazondigital.Repositories.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class IngredientService {
    private IngredientRepository ingredientRepository;

    public List<Ingredient> getAllIngredients() {return ingredientRepository.findAll();}

    public Ingredient getIngredientById(int id) {return ingredientRepository.findById(id).orElse(null);}

    public void save(Ingredient ingredient) {ingredientRepository.save(ingredient);}

    public void delete(Ingredient ingredient) {ingredientRepository.delete(ingredient);}
}

