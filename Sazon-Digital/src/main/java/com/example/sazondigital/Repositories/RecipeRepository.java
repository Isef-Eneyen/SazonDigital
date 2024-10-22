package com.example.sazondigital.Repositories;

import com.example.sazondigital.Models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
}
