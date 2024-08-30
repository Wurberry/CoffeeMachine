package ru.coffee.evstigneev.spring.coffeemachine.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.coffee.evstigneev.spring.coffeemachine.domain.entity.DrinkType;

public interface DrinkTypeRepository extends JpaRepository<DrinkType, Long> {

    DrinkType getByNameIgnoreCase(String name);
}
