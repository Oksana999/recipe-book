package com.oksanasb.recipebook.controllers;

import com.oksanasb.recipebook.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class RecipePageBookController {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipePageBookController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("recipes", recipeRepository.findAll());
        return "list";
    }
}
