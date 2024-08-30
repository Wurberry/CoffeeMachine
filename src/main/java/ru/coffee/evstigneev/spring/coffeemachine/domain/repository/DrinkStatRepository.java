package ru.coffee.evstigneev.spring.coffeemachine.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.coffee.evstigneev.spring.coffeemachine.domain.entity.DrinkStat;

public interface DrinkStatRepository extends JpaRepository<DrinkStat, Long> {

    @Query("SELECT ds.drinkTypeId FROM DrinkStat ds GROUP BY ds.drinkTypeId ORDER BY COUNT(ds.drinkTypeId) DESC LIMIT 1")
    Long findFirstByOrderByCountDesc();
}
