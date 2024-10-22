package com.example.sazondigital.Repositories;

import com.example.sazondigital.Models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
}
