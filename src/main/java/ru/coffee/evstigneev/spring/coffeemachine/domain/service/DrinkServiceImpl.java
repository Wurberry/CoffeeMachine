package ru.coffee.evstigneev.spring.coffeemachine.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.coffee.evstigneev.spring.coffeemachine.domain.entity.DrinkType;
import ru.coffee.evstigneev.spring.coffeemachine.domain.entity.Ingredient;
import ru.coffee.evstigneev.spring.coffeemachine.domain.repository.DrinkTypeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DrinkServiceImpl implements DrinkService {

    private final DrinkTypeRepository drinkTypeRepository;
    private final IngredientService ingredientService;
    private final DrinkStatService drinkStatService;

    public List<DrinkType> getDrinksType() {
        return drinkTypeRepository.findAll();
    }

    public DrinkType getDrinkById(long id) {
        return drinkTypeRepository.findById(id).orElse(null);
    }

    @Transactional
    public boolean generateDrink(long id) {
        List<Ingredient> ingredients = ingredientService.checkIngredients(id);

        if (ingredients == null) return false;

        ingredientService.saveIngredients(ingredients);
        drinkStatService.saveStat(id);

        return true;
    }

    public DrinkType getDrinkByName(String name) {
        return drinkTypeRepository.getByNameIgnoreCase(name);
    }

    public String createDrinkType(String name) {
        DrinkType drinkType = drinkTypeRepository.save(new DrinkType(name.toLowerCase()));
        return "Идентификатор вашего напитка " + drinkType.getId();
    }
}
