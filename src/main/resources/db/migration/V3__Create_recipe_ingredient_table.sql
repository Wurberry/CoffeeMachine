CREATE TABLE recipe_ingredient (
    id BIGSERIAL PRIMARY KEY,
    drink_type_id BIGINT NOT NULL,
    ingredient_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (drink_type_id) REFERENCES drink_type(id),
    FOREIGN KEY (ingredient_id) REFERENCES ingredient(id)
);