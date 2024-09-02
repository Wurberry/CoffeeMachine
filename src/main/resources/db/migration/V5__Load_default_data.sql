INSERT INTO drink_type (name) VALUES ('эспрессо');
INSERT INTO drink_type (name) VALUES ('американо');
INSERT INTO drink_type (name) VALUES ('капучино');

INSERT INTO ingredient (name, quantity) VALUES ('кофе', 1000);
INSERT INTO ingredient (name, quantity) VALUES ('вода', 1000);
INSERT INTO ingredient (name, quantity) VALUES ('молоко', 1000);

INSERT INTO recipe_ingredient (drink_type_id, ingredient_id, quantity) VALUES (1, 1, 8);
INSERT INTO recipe_ingredient (drink_type_id, ingredient_id, quantity) VALUES (1, 2, 30);

INSERT INTO recipe_ingredient (drink_type_id, ingredient_id, quantity) VALUES (2, 1, 8);
INSERT INTO recipe_ingredient (drink_type_id, ingredient_id, quantity) VALUES (2, 2, 60);

INSERT INTO recipe_ingredient (drink_type_id, ingredient_id, quantity) VALUES (3, 1, 8);
INSERT INTO recipe_ingredient (drink_type_id, ingredient_id, quantity) VALUES (3, 2, 30);
INSERT INTO recipe_ingredient (drink_type_id, ingredient_id, quantity) VALUES (3, 3, 60);