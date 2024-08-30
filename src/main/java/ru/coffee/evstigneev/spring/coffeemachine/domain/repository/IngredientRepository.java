package ru.coffee.evstigneev.spring.coffeemachine.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.coffee.evstigneev.spring.coffeemachine.domain.entity.Ingredient;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
