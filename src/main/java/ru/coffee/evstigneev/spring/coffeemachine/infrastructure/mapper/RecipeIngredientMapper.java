package ru.coffee.evstigneev.spring.coffeemachine.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.coffee.evstigneev.spring.coffeemachine.domain.entity.RecipeIngredient;
import ru.coffee.evstigneev.spring.coffeemachine.infrastructure.dto.RecipeIngredientDtoResponse;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RecipeIngredientMapper {

    RecipeIngredientDtoResponse toDto(RecipeIngredient entity);
}
