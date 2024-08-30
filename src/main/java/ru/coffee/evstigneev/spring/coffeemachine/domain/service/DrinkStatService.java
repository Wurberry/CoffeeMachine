package ru.coffee.evstigneev.spring.coffeemachine.domain.service;

import ru.coffee.evstigneev.spring.coffeemachine.domain.entity.DrinkStat;

import java.util.List;

public interface DrinkStatService {

    List<DrinkStat> getDrinksStat();

    void saveStat(long id);

    Long getPopularDrink();
}
