package ru.coffee.evstigneev.spring.coffeemachine.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import ru.coffee.evstigneev.spring.coffeemachine.domain.entity.Ingredient;
import ru.coffee.evstigneev.spring.coffeemachine.domain.entity.RecipeIngredient;
import ru.coffee.evstigneev.spring.coffeemachine.domain.repository.IngredientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;
    private final RecipeService recipeService;

    public List<Ingredient> checkIngredients(long id) {
        // Получение списка RecipeIngredient по drinkTypeId
        List<RecipeIngredient> recipeIngredients = recipeService.findRecipeByDrinkTypeId(id);

        if (CollectionUtils.isEmpty(recipeIngredients)) return null;

        // Извлечение идентификаторов ингредиентов рецепта
        List<Long> recipeIngredientIds = recipeIngredients.stream()
                .map(RecipeIngredient::getIngredientId)
                .collect(Collectors.toList());

        // Получение списка ингредиентов из хранилища по идентификаторам
        List<Ingredient> ingredientsStorage = ingredientRepository.findAllById(recipeIngredientIds);

        // Формирование мапы с ингредиентами из хранилища и их количеством
        Map<Long, Integer> ingredientStorageMap = ingredientsStorage.stream()
                .collect(Collectors.toMap(Ingredient::getId, Ingredient::getQuantity));

        // Создание списка ингредиентов для обновления
        List<Ingredient> ingredientsStorageUpdate = new ArrayList<>();

        // Проверка наличия всех необходимых ингредиентов и их количества
        for (RecipeIngredient recipeIngredient : recipeIngredients) {
            long ingredientId = recipeIngredient.getIngredientId();
            int requiredQuantity = recipeIngredient.getQuantity();

            Ingredient ingredientStorageUpdate = ingredientsStorage.stream()
                    .filter(ingredient -> ingredient.getId() == (ingredientId))
                    .findFirst().orElse(null);

            if (ingredientStorageUpdate == null || ingredientStorageUpdate.getQuantity() < requiredQuantity) {
                return null; // Не хватает ингредиента или его количества
            }

            // Обновление количества ингредиентов в хранилище
            ingredientStorageUpdate.setQuantity(ingredientStorageUpdate.getQuantity() - requiredQuantity);
            ingredientsStorageUpdate.add(ingredientStorageUpdate);
        }

        return ingredientsStorageUpdate;
    }

    public List<Ingredient> getIngredients() {
        return ingredientRepository.findAll();
    }

    public void saveIngredients(List<Ingredient> ingredients) {
        ingredientRepository.saveAll(ingredients);
    }
}
