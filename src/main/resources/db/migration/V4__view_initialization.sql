USE restaurant_db;

BEGIN;

CREATE VIEW trending_menu_item AS
SELECT favorite_menu_item.menu_item_id AS id, menu_item.name, CONCAT(menu_item.price, '$') AS price, COUNT(*) as number_of_likes
FROM favorite_menu_item
         JOIN menu_item ON favorite_menu_item.menu_item_id = menu_item.id
WHERE favorite_menu_item.liked_at >= NOW() - INTERVAL 30 DAY
GROUP BY favorite_menu_item.menu_item_id
ORDER BY number_of_likes DESC;

CREATE VIEW credit_card_statistics AS
SELECT payment.credit_card_id,
       account.username,
       credit_card.holder,
       credit_card.number,
       CONCAT(credit_card.expiration_month, '/', credit_card.expiration_year) AS expiration,
       CONCAT(SUM(payment.total), '$') AS total
FROM account
         JOIN online_order ON account.username = online_order.username
         JOIN payment ON online_order.payment_id = payment.id
         JOIN credit_card ON payment.credit_card_id = credit_card.id
WHERE payment.happened_at >= NOW() - INTERVAL 30 DAY
GROUP BY payment.credit_card_id, account.username;

COMMIT;