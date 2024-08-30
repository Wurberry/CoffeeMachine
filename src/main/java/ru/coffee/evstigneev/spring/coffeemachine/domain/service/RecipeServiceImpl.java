package ru.coffee.evstigneev.spring.coffeemachine.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.coffee.evstigneev.spring.coffeemachine.domain.entity.RecipeIngredient;
import ru.coffee.evstigneev.spring.coffeemachine.domain.exception.BusinessError;
import ru.coffee.evstigneev.spring.coffeemachine.domain.exception.BusinessException;
import ru.coffee.evstigneev.spring.coffeemachine.domain.repository.RecipeIngredientRepository;
import ru.coffee.evstigneev.spring.coffeemachine.infrastructure.dto.RecipeIngredientDtoRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeIngredientRepository recipeIngredientRepository;

    public void createRecipe(RecipeIngredientDtoRequest recipeIngredient) {
        RecipeIngredient recipeIngredientEntity = new RecipeIngredient();

        recipeIngredientEntity.setDrinkTypeId(recipeIngredient.getDrinkTypeId());
        recipeIngredientEntity.setIngredientId(recipeIngredient.getIngredientId());
        recipeIngredientEntity.setQuantity(recipeIngredient.getQuantity());

        try {
            recipeIngredientRepository.save(recipeIngredientEntity);
        } catch (Exception e) {
            throw new BusinessException(BusinessError.INGREDIENT_OR_DRINK_NOT_FOUND);
        }
    }

    public List<RecipeIngredient> findRecipeByDrinkTypeId(long id) {
        return recipeIngredientRepository.findByDrinkTypeId(id);
    }
}
