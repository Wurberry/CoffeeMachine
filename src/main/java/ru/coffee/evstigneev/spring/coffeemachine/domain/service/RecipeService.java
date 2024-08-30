package ru.coffee.evstigneev.spring.coffeemachine.domain.service;

import org.springframework.stereotype.Service;
import ru.coffee.evstigneev.spring.coffeemachine.domain.entity.RecipeIngredient;
import ru.coffee.evstigneev.spring.coffeemachine.infrastructure.dto.RecipeIngredientDtoRequest;

import java.util.List;

@Service
public interface RecipeService {

    void createRecipe(RecipeIngredientDtoRequest recipeIngredient);

    List<RecipeIngredient> findRecipeByDrinkTypeId(long id);
}
