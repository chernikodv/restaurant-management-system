USE restaurant_db;

BEGIN;

DELIMITER $$

CREATE FUNCTION count_saved_credit_card_by_id (
    credit_card_id INT
)
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE credit_card_amount INT;

    SELECT COUNT(*) INTO credit_card_amount
    FROM account_credit_card AS acc
    WHERE acc.credit_card_id = credit_card_id;

    RETURN credit_card_amount;
END $$

DELIMITER ;

DELIMITER $$

CREATE FUNCTION online_order_total_price_v2 (
    online_order_id INT
)
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE total_price DECIMAL(6,2);

    SELECT SUM(item.price * info.quantity) INTO total_price
    FROM online_order_info AS info
             JOIN menu_item AS item ON info.menu_item_id = item.id
    WHERE info.online_order_id = online_order_id
    GROUP BY info.online_order_id;

    RETURN CAST(COALESCE(total_price,0.00) AS DECIMAL(30,2));
END $$

DELIMITER ;

DELIMITER $$

CREATE FUNCTION employee_tips_for_last_30_days (
    employee_id INT
)
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE tips DECIMAL(6,2);

    SELECT SUM(online_order.tip) INTO tips
    FROM employee
             JOIN online_order ON employee.id = online_order.employee_id
    WHERE employee.id = employee_id
    GROUP BY employee.id;

    RETURN tips;
END $$

DELIMITER ;

COMMIT;