package ru.coffee.evstigneev.spring.coffeemachine.application.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.coffee.evstigneev.spring.coffeemachine.domain.entity.DrinkStat;
import ru.coffee.evstigneev.spring.coffeemachine.domain.service.DrinkStatService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@Tag(name = "Статистика", description = "АПИ для работы со статистикой")
public class DrinkStatController {

    private final DrinkStatService drinkStatService;

    @GetMapping("statistic")
    @Operation(summary = "Узнать статистику напитков", description = "Возвращает статистику приготовления напитков")
    public List<DrinkStat> getDrinkStat() {
        return drinkStatService.getDrinksStat();
    }

    @GetMapping("popularDrink")
    @Operation(summary = "Узнать популярный напиток", description = "Узнать самый популярный напиток")
    public Long getPopularDrink() {
        return drinkStatService.getPopularDrink();
    }

}
