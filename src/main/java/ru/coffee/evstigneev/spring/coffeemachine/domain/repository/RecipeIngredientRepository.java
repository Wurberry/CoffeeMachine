package ru.coffee.evstigneev.spring.coffeemachine.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.coffee.evstigneev.spring.coffeemachine.domain.entity.RecipeIngredient;

import java.util.List;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {

    List<RecipeIngredient> findByDrinkTypeId(long id);
}
