package ru.coffee.evstigneev.spring.coffeemachine.domain.messages.exception;

import lombok.Getter;

@Getter
public enum BusinessError {
    DRINK_TYPE_NOT_FOUND("Вид напитка не найден"),
    DRINK_NOT_READY("Убедитесь, в корректности данных"),
    INGREDIENT_OR_DRINK_NOT_FOUND("Ингредиент или вид напитка не найден");

    private final String message;

    BusinessError(String message) {
        this.message = message;
    }

}
