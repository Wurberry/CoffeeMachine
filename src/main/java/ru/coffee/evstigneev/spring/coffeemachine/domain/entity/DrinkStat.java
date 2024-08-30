package ru.coffee.evstigneev.spring.coffeemachine.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "drink_stat")
public class DrinkStat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate;

    @Column(name = "drink_type_id")
    private long drinkTypeId;

}
