package ru.coffee.evstigneev.spring.coffeemachine.application.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.coffee.evstigneev.spring.coffeemachine.domain.entity.DrinkType;
import ru.coffee.evstigneev.spring.coffeemachine.domain.service.DrinkService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@Tag(name = "Напитки", description = "АПИ для работы с напитками")
public class DrinkController {

    private final DrinkService drinkService;

    @GetMapping("allType")
    // TODO: Добавить проверку доступных напитков по рецептам
    @Operation(summary = "Получить все виды напитков", description = "Возвращает список всех видов напитков")
    public List<DrinkType> getDrinks() {
        return drinkService.getDrinksType();
    }

    @GetMapping("{id}")
    @Operation(summary = "Получить напиток по идентификатору", description = "Узнать по идентификатору есть ли такой напиток")
    public DrinkType getDrinkById(@PathVariable("id") Long id) {
        return drinkService.getDrinkById(id);
    }

    @GetMapping("name")
    @Operation(summary = "Получить напиток по названию", description = "Узнать по названию есть ли такой напиток")
    public DrinkType getDrinkByName(@RequestParam("name") String name) {
        return drinkService.getDrinkByName(name);
    }

    @GetMapping("generateDrink")
    @Operation(summary = "Приготовление напитка", description = "Приготовление напитка по идентификатору его вида")
    public ResponseEntity<String> generateDrink(@RequestParam("id") Long id) {
        return drinkService.generateDrink(id);
    }

    @PostMapping
    @Operation(summary = "Добавить вид напитка", description = "Создание вида напитка, имя приводится в нижний регистр")
    @ResponseStatus(HttpStatus.CREATED)
    public String createDrinkType(@RequestBody String name) {
        return drinkService.createDrinkType(name);
    }

    // TODO: Добавить удаление типов

}
