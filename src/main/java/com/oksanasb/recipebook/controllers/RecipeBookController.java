package com.oksanasb.recipebook.controllers;

import com.oksanasb.recipebook.entities.RecipeEntity;
import com.oksanasb.recipebook.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeBookController {
    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping("/recipes")
    public List<RecipeEntity> find(){
        return recipeRepository.findAll();
    }
}
