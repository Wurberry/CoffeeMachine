package ru.coffee.evstigneev.spring.coffeemachine.domain.service;

import ru.coffee.evstigneev.spring.coffeemachine.domain.entity.DrinkType;

import java.util.List;

public interface DrinkService {

    List<DrinkType> getDrinksType();

    DrinkType getDrinkById(long id);

    boolean generateDrink(long id);

    DrinkType getDrinkByName(String name);

    String createDrinkType(String name);
}
