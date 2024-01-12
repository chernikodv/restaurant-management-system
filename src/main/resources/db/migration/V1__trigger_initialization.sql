USE restaurant_db;

BEGIN;

DELIMITER $$

CREATE TRIGGER ingredient_calories
    BEFORE INSERT
    ON ingredient FOR EACH ROW
BEGIN
    IF (NEW.calories_per_serving_size IS NULL) THEN
        SET NEW.calories_per_serving_size = 9 * NEW.fat_per_serving_size + 4 * (NEW.protein_per_serving_size + NEW.carbohydrate_per_serving_size);
    END IF;
END $$

DELIMITER ;

COMMIT;