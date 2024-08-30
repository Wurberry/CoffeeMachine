package ru.coffee.evstigneev.spring.coffeemachine.application.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.coffee.evstigneev.spring.coffeemachine.domain.entity.Ingredient;
import ru.coffee.evstigneev.spring.coffeemachine.domain.service.IngredientService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@Tag(name = "Ингредиенты", description = "АПИ для работы с ингредиентами")
public class IngredientController {

    private final IngredientService ingredientService;

    @GetMapping("ingredients")
    @Operation(summary = "Узнать доступные ингредиенты", description = "Возвращает список всех ингредиентов")
    public List<Ingredient> getIngredients() {
        return ingredientService.getIngredients();
    }

}
