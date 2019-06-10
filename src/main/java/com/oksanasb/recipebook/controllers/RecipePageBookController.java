package com.oksanasb.recipebook.controllers;

import com.oksanasb.recipebook.entities.RecipeEntity;
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

    @RequestMapping(value = "new" , method = RequestMethod.GET)
    public String newForm(){
        return "recipe";
    }

    @RequestMapping(value = "new" , method = RequestMethod.POST)
    public String save(Model model, String name, String description){
        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setName(name);
        recipeEntity.setDescription(description);
        recipeRepository.save(recipeEntity);
        model.addAttribute("recipe", recipeEntity);
        model.addAttribute("name", name);
        model.addAttribute("description", description);
        return "recipe";
    }
}
