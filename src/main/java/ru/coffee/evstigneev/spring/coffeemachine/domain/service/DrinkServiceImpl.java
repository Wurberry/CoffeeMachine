package ru.coffee.evstigneev.spring.coffeemachine.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.coffee.evstigneev.spring.coffeemachine.domain.entity.DrinkType;
import ru.coffee.evstigneev.spring.coffeemachine.domain.entity.Ingredient;
import ru.coffee.evstigneev.spring.coffeemachine.domain.repository.DrinkTypeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DrinkServiceImpl implements DrinkService {

    private final DrinkTypeRepository drinkTypeRepository;
    private final IngredientServiceImpl ingredientServiceImpl;
    private final DrinkStatServiceImpl drinkStatServiceImpl;

    public List<DrinkType> getDrinksType() {
        return drinkTypeRepository.findAll();
    }

    public DrinkType getDrinkById(long id) {
        return drinkTypeRepository.findById(id).orElse(null);
    }

    public ResponseEntity<String> generateDrink(long id) {
        List<Ingredient> ingredients = ingredientServiceImpl.checkIngredients(id);

        if (ingredients == null) return new ResponseEntity<String>("Не хватило ингредиентов", HttpStatus.SERVICE_UNAVAILABLE);

        ingredientServiceImpl.saveIngredients(ingredients);
        drinkStatServiceImpl.saveStat(id);

        return new ResponseEntity<String>("Ваш напиток готов", HttpStatus.ACCEPTED);
    }

    public DrinkType getDrinkByName(String name) {
        return drinkTypeRepository.getByNameIgnoreCase(name);
    }

    public String createDrinkType(String name) {
        DrinkType drinkType = drinkTypeRepository.save(new DrinkType(name.toLowerCase()));
        return "Идентификатор вашего напитка " + drinkType.getId();
    }

    @Override
    public boolean checkDrinkExists(long drinkTypeId) {
        return drinkTypeRepository.existsById(drinkTypeId);
    }
}
