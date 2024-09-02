package ru.coffee.evstigneev.spring.coffeemachine.domain.messages.success;

import lombok.Getter;

@Getter
public enum SuccessMessage {
    DRINK_DONE("Ваш напиток готов");

    private final String message;

    SuccessMessage(String message) {
        this.message = message;
    }
}
