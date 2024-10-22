package com.example.sazondigital.Services;

import com.example.sazondigital.Models.Recipe;
import com.example.sazondigital.Repositories.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private RecipeRepository recipeRepository;

    public List<Recipe> getAllRecipes(){return recipeRepository.findAll();}

    public Recipe getRecipeById(int id){return recipeRepository.findById(id).orElse(null);}

    public void save(Recipe recipe){recipeRepository.save(recipe);}

    public void delete(Recipe recipe){recipeRepository.delete(recipe);}
}
