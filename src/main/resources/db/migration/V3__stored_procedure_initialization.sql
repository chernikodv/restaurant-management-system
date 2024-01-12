USE restaurant_db;

BEGIN;

-- return nutrition facts for the given menu item
DELIMITER $$

CREATE PROCEDURE menu_item_nutrition_facts (
    IN menu_item_id INT
)
BEGIN
    SELECT
        SUM(menu_item_ingredient.serving_size * ingredient.fat_per_serving_size) as fat,
        SUM(menu_item_ingredient.serving_size * ingredient.protein_per_serving_size) AS protein,
        SUM(menu_item_ingredient.serving_size * ingredient.carbohydrate_per_serving_size) AS carbohydrate,
        SUM(menu_item_ingredient.serving_size * ingredient.calories_per_serving_size) AS calories
    FROM menu_item_ingredient
             JOIN ingredient ON menu_item_ingredient.ingredient_id = ingredient.id
    WHERE menu_item_ingredient.menu_item_id = menu_item_id
    GROUP BY menu_item_ingredient.menu_item_id;
END $$

DELIMITER ;

-- return average nutrition facts for the given category
DELIMITER $$

CREATE PROCEDURE category_average_nutrition_facts (
    IN category_id INT
)
BEGIN
    SELECT AVG(menu_item_nutrion_facts.fat_per_menu_item) AS fat,
           AVG(menu_item_nutrion_facts.protein_per_menu_item) AS protein,
           AVG(menu_item_nutrion_facts.carbohydrate_per_menu_item) AS carbohydrate,
           AVG(menu_item_nutrion_facts.calories_per_menu_item) AS calories
    FROM
        (SELECT SUM(menu_item_ingredient.serving_size * ingredient.fat_per_serving_size) AS fat_per_menu_item,
                SUM(menu_item_ingredient.serving_size * ingredient.protein_per_serving_size) AS protein_per_menu_item,
                SUM(menu_item_ingredient.serving_size * ingredient.carbohydrate_per_serving_size) AS carbohydrate_per_menu_item,
                SUM(menu_item_ingredient.serving_size * ingredient.calories_per_serving_size) AS calories_per_menu_item
         FROM category
                  JOIN menu_item on category.id = menu_item.category_id
                  JOIN menu_item_ingredient ON menu_item.id = menu_item_ingredient.menu_item_id
                  JOIN ingredient ON menu_item_ingredient.ingredient_id = ingredient.id
         WHERE category.id = category_id
         GROUP BY menu_item.id) AS menu_item_nutrion_facts;
END $$

DELIMITER ;

-- return nutrition facts per the given order
DELIMITER $$

CREATE PROCEDURE order_nutrition_facts (
    IN online_order_id INT
)
BEGIN
    SELECT SUM(nutrition_facts.fat_per_quantity_of_menu_item) AS fat,
           SUM(nutrition_facts.protein_per_quantity_of_menu_item) AS protein,
           SUM(nutrition_facts.carbohydrate_per_quantity_of_menu_item) AS carbohydrate,
           SUM(nutrition_facts.calories_per_quantity_of_menu_item) AS calories
    FROM (
             SELECT SUM(online_order_info.quantity * menu_item_ingredient.serving_size * ingredient.fat_per_serving_size) AS fat_per_quantity_of_menu_item,
                    SUM(online_order_info.quantity * menu_item_ingredient.serving_size * ingredient.protein_per_serving_size) AS protein_per_quantity_of_menu_item,
                    SUM(online_order_info.quantity * menu_item_ingredient.serving_size * ingredient.carbohydrate_per_serving_size) AS carbohydrate_per_quantity_of_menu_item,
                    SUM(online_order_info.quantity * menu_item_ingredient.serving_size * ingredient.calories_per_serving_size) AS calories_per_quantity_of_menu_item
             FROM online_order
                      JOIN online_order_info ON online_order.id = online_order_info.online_order_id
                      JOIN menu_item ON online_order_info.menu_item_id = menu_item.id
                      JOIN menu_item_ingredient ON menu_item.id = menu_item_ingredient.menu_item_id
                      JOIN ingredient ON menu_item_ingredient.ingredient_id = ingredient.id
             WHERE online_order.id = online_order_id
             GROUP BY online_order.id, online_order_info.menu_item_id
         ) AS nutrition_facts;
END $$

DELIMITER ;

COMMIT;