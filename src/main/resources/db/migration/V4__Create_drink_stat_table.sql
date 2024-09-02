CREATE TABLE drink_stat (
    id BIGSERIAL PRIMARY KEY,
    purchase_date TIMESTAMP NOT NULL,
    drink_type_id BIGINT NOT NULL,
    FOREIGN KEY (drink_type_id) REFERENCES drink_type(id)
);