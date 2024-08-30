package ru.coffee.evstigneev.spring.coffeemachine.application.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.coffee.evstigneev.spring.coffeemachine.domain.service.RecipeService;
import ru.coffee.evstigneev.spring.coffeemachine.infrastructure.dto.RecipeIngredientDtoRequest;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@Tag(name = "Рецепты", description = "АПИ для работы с рецептами")
public class RecipeController {

    private final RecipeService recipeService;

    @PostMapping("recipes")
    @Operation(summary = "Создать рецепт", description = "Создание рецепта")
    @ResponseStatus(HttpStatus.CREATED)
    public void createRecipe(@RequestBody RecipeIngredientDtoRequest recipeIngredient) {
        recipeService.createRecipe(recipeIngredient);
    }

}
