package ru.coffee.evstigneev.spring.coffeemachine.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "recipe_ingredient")
public class RecipeIngredient {

    // TODO: Сдлеать примитивы объектами
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "drink_type_id")
    private long drinkTypeId;

    @Column(name = "ingredient_id")
    private long ingredientId;

    @Column(name = "quantity")
    private int quantity;
}
