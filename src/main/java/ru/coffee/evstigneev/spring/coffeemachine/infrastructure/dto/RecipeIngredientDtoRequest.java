package ru.coffee.evstigneev.spring.coffeemachine.infrastructure.dto;

import lombok.Data;

@Data
public class RecipeIngredientDtoRequest {
    private long drinkTypeId;

    private long ingredientId;

    private int quantity;
}
