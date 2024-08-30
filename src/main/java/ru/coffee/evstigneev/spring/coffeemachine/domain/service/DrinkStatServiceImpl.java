package ru.coffee.evstigneev.spring.coffeemachine.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.coffee.evstigneev.spring.coffeemachine.domain.entity.DrinkStat;
import ru.coffee.evstigneev.spring.coffeemachine.domain.repository.DrinkStatRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DrinkStatServiceImpl implements DrinkStatService {

    private final DrinkStatRepository drinkStatRepository;

    public List<DrinkStat> getDrinksStat() {
        return drinkStatRepository.findAll();
    }

    public void saveStat(long id) {
        DrinkStat drinkStat = new DrinkStat();
        drinkStat.setDrinkTypeId(id);
        drinkStat.setPurchaseDate(LocalDateTime.now());
        drinkStatRepository.save(drinkStat);
    }

    @Override
    public Long getPopularDrink() {
        return drinkStatRepository.findFirstByOrderByCountDesc();
    }
}
