package ru.coffee.evstigneev.spring.coffeemachine.domain.exception;

public enum BusinessError {
    DRINK_TYPE_NOT_FOUND("Вид напитка не найден"),
    INGREDIENT_NOT_FOUND("Ингредиента не найден"),
    INGREDIENT_OR_DRINK_NOT_FOUND("Ингредиент или вид напитка не найден"),
    INGREDIENT_NOT_ENOUGH("Ингредиентов недостаточно");

    private final String message;

    BusinessError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
