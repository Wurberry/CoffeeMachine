package ru.coffee.evstigneev.spring.coffeemachine.domain.service;

import org.springframework.stereotype.Service;
import ru.coffee.evstigneev.spring.coffeemachine.domain.entity.Ingredient;

import java.util.List;

@Service
public interface IngredientService {

    List<Ingredient> checkIngredients(long id);

    List<Ingredient> getIngredients();

    void saveIngredients(List<Ingredient> ingredients);
}
