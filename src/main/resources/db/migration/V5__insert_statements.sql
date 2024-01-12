USE restaurant_db;

BEGIN;

INSERT INTO customer (phone_number, first_name, last_name)
VALUES
('617-123-4567', 'Dmitriy', 'Chernikov'),
('617-123-6789', 'Pazin', 'Tarasansombat'),
('617-123-5678', 'Pavel', 'Chernikov'),
('617-123-7890', 'Dinara', 'Boyko'),
('617-124-3456', 'Wenlin', 'Fang'),
('617-124-4567', 'Virgil', 'Pavlu'),
('617-124-5678', 'David', 'Choffnes'),
('617-124-6789', 'Maria', 'Jump'),
('617-125-1234', 'David', 'Smith'),
('617-125-8901', 'Danny', 'Benjamin');

INSERT INTO account (username, password, email, phone_number)
VALUES
('dchernikov', '1qaz2wsx', 'chernikov.d@northeastern.edu', '617-123-4567'),
('ptarasansombat', '2wsx3edc', 'tarasansombat.p@northeastern.edu', '617-123-6789'),
('pchernikov', '3edc4rfv', 'chernikov.p@northeastern.edu', '617-123-5678'),
('dboyko', '4rfv5tgb', 'boyko.d@northeastern.edu', '617-123-7890'),
('wfang', '5tgb6yhn', 'wang.f@northeastern.edu', '617-124-3456'),
('vpavlu', '6yhn7ujm', 'pavlu.v@northeastern.edu', '617-124-4567'),
('dchoffnes', '7ujm7ujm', 'choffnes.d@northeastern.edu', '617-124-5678'),
('mjump', '7ujm6yhn', 'jump.m@northeastern.edu', '617-124-6789'),
('dsmith', '6yhn5tgb', 'smith.d@northeastern.edu', '617-125-1234'),
('dbenjamin', '6yhn5tgb', 'benjamin.d@northeastern.edu', '617-125-8901');

INSERT INTO ingredient (name, fat_per_serving_size, protein_per_serving_size, carbohydrate_per_serving_size)
VALUES
('Avocado', 7, 4, 0),
('Cucumber', 0, 1, 1),
('Crab Meat', 5, 5, 2),
('Mayo', 10, 0, 2),
('Baby Spinach', 0, 1, 1),
('Egg', 2, 7, 1),
('Tuna', 5, 10, 0),
('Sweet Chili Sauce', 10, 0, 3),
('Seaweed', 0, 1, 2),
('Sesame Seed', 2, 1, 2),
('Sesame Oil', 3, 1, 2),
('Chicken', 0, 10, 0),
('Lettuce', 0, 1, 1),
('Carrot', 0, 1, 1),
('Purple Cabbage', 0, 1, 1),
('Ginger Dressing', 12, 0, 2),
('Broccoli', 0, 1, 1),
('Mushroom', 2, 1, 2),
('Tofu', 3, 3, 1),
('Scallion', 3, 2, 1),
('Salmon', 4, 12, 1),
('Pork', 6, 12, 1),
('Ginger Sauce', 10, 1, 1),
('Olive Oil', 10, 0, 2),
('Shumai', 7, 7, 5),
('Shellfish', 1, 1, 1),
('Eel', 8, 10, 1),
('Tempura Flake', 5, 5, 2),
('Sweet Soy Sauce', 8, 0, 2),
('Sushi Rice', 3, 1, 0),
('Shrimp', 6, 9, 2),
('Asparagus', 0, 1, 1),
('Mango', 0, 1, 1),
('Sweet Yam', 10, 3, 3),
('Cream Cheese', 8, 2, 1),
('Water', 0, 0, 0);

INSERT INTO category (name)
VALUES
('Salad'),
('Soup'),
('Appetizers'),
('Poke Bowl'),
('Burrito Roll'),
('Fried Roll'),
('Cooked Maki'),
('Special Maki'),
('Sushi Entrees / Platter'),
('Beverage');

INSERT INTO menu_item (name, description, price, category_id)
VALUES
-- salad
('Avocado Salad', 'Avocado, cucumber & crab meat mixed w. mayo, served on baby spinach. Contains gluten, egg.', 10.99, 1),
('Spicy Tuna Salad', 'Tuna & mango mixed w. sweet chili sauce, serves on seaweed salad. Contains: sesame seed, sesame oil, soy.', 17.99, 1),
('Grilled Chicken Salad', 'With lettuce, carrots and purple cabbage with ginger dressing. contains egg, soy.', 15.99, 1),
-- soup
('Grilled Salmon Udon Soup', 'With broccoli and mushroom; side of green salad (lettuce, carrot and purple cabbage) and miso soup (tofu, shiitake mushroom, seaweed & scallion in mushroom flavored miso broth).', 24.99, 2),
('Chicken Cutlet Udon Soup', 'Deep fried with broccoli and mushroom; side of green salad (lettuce, carrot and purple cabbage) and miso soup (tofu, shiitake mushroom, seaweed & scallion in mushroom flavored miso broth).', 25.99, 2),
('Pork Cutlet Udon Soup', 'Deep fried with broccoli and mushroom; side of green salad (lettuce, carrot and purple cabbage) and miso soup (tofu, shiitake mushroom, seaweed & scallion in mushroom flavored miso broth).', 25.99, 2),
-- appetizers
('Scallion Pie', '8 pieces. Serve w. ginger sauce.', 8.99, 3),
('Shumai (Deep Fried)', '6 pieces. Serve w. ginger sauce. Contains gluten, shellfish.', 7.99, 3),
('Shumai (Steamed)', '6 pieces. Serve w. ginger sauce. Contains gluten, shellfish.', 7.99, 3),
('Pork Gyoza (Pan Fried)', '6 pieces. Serve w. ginger sauce. Contains gluten.', 8.99, 3),
('Pork Gyoza (Steamed)', '6 pieces. Serve w. ginger sauce. Contains gluten.', 8.99, 3),
-- poke bowl
('POKE-Godzilla', 'Cooked. Bakes salmon, grilled eel, avocado, tempura flake, sweet soy sauce & sesame seed on a bowl of sushi rice. Contains gluten.', 23.99, 4),
('POKE-Scorpion', 'Cooked. Grilled eel, boiled shrimp, cucumber, avocado, sesame seed & sweet soy sauce on a bowl of sushi rice. Contains gluten.', 23.99, 4),
('POKE-Super Dragon', 'Cooked. Tempura shrimp, grilled eel, crab meat, avocado, sweet soy sauce & sesame seed on a bowl of sushi rice. Contains gluten.', 23.99, 4),
-- burrito roll
('BURRITO-Caterpillar', 'Cooked. Grilled eel, avocado, cucumber w. sweet soy sauce wrapped by seaweed, sushi rice & sesame seed. Contains gluten.', 18.99, 5),
('BURRITO-Snow Mountain', 'Cooked. Tempura shrimp, crab meat, king crab meat & snow crab meat w. sweet mayo wrapped by seaweed, sushi rice & sesame seed. Contains gluten, egg.', 18.99, 5),
('BURRITO-Green Mile', 'Cooked. Baked salmon, asparagus & avocado wrapped by seaweed, sushi rice & sesame seed. Contains gluten, onion powder, ground black pepper, paprika powder, ginger powder.', 18.99, 5),
-- fried roll
('Fried Baked Salmon', 'Choose Style. Deep fried with tempura batter, baked salmon, avocado and sweet soy sauce wrapped by seaweed, sushi rice and sesame seed.', 12.99, 6),
('Fried Salmon Avocado', 'Choose Style. Deep fried with tempura batter, salmon and avocado wrapped by seaweed, sushi rice and sesame seed.', 12.99, 6),
('Fried Eel Avocado', 'Choose Style. Deep fried with tempura batter, eel and avocado wrapped by seaweed, sushi rice and sesame seed.', 12.99, 6),
-- cooked maki
('California Maki', '8 pieces. Crab stick, avocado & cucumber. Contains: gluten.', 7.99, 7),
('Shrimp Tempura Maki', '8 pieces. Tempura shrimp, avocado, cucumber & sweet soy sauce. Contains gluten.', 8.99, 7),
('Chicken Tempura Maki', '8 pieces. Tempura chicken, avocado, mango & sweet soy sauce. Contains gluten.', 8.99, 7),
-- special maki
('My Sweet Day', 'Cooked. 10 pieces. Tempura sweet yam, avocado & cream cheese inside, topped w. mixed of king crab, snow crab & crab meat w. mayo. Contains gluten, dairy, egg.', 19.99, 8),
('Scorpion', 'Cooked. 10 pieces. Grilled eel, avocado & cucumber inside, topped w. shrimp & sweet soy sauce. Contains gluten.', 20.99, 8),
('Snow Mountain', 'Cooked. 10 pieces. Tempura shrimp & crab meat inside, topped w. mixed of king crab, snow crab, crab meat w. mayo & finished w. extra sweet mayo. Contains gluten, egg.', 19.99, 8),
('Moley Crab', 'Cooked. 10 pieces. Tempura mushroom, asparagus, cucumber & jalapeno, topped w. torched crab meat mixed w. spicy mayo, finished w. scallion, tempura flakes, and sweet soy sauce. Contains gluten, egg, sesame oil.', 20.99, 8),
('Super Dragon', 'Cooked. 10 pieces. Tempura shrimp, avocado, & crab meat inside, topped w. eel, avocado, & sweet soy sauce. Contains gluten.', 21.99, 8),
-- sushi entrees / platter
('Spicy Roll Platter', 'Spicy salmon maki (8 pieces), spicy tuna maki (8 pieces) & spicy albacore maki (8 pieces).', 23.99, 9),
('Donburi', 'Choose your 10 pieces of fresh sliced fish over a bed of organic rice w. oshinko, radish, sweet egg, cucumber & kampyo.', 27.99, 9),
('Sashimi Combo', 'Chef choice of 18 pieces of fresh sliced fish w. sushi rice.', 44.99, 9),
-- beverage
('Oolong Tea', 'Unsweetened.', 4.00, 10),
('Green Tea', 'Unsweetened.', 4.00, 10);

INSERT INTO menu_item_ingredient (menu_item_id, ingredient_id, serving_size)
VALUES
-- Avocado Salad
(1, 1, 1),
(1, 2, 2),
(1, 3, 2),
(1, 4, 1),
(1, 5, 3),
(1, 6, 2),
-- Spicy Tuna Salad
(2, 7, 2),
(2, 8, 1),
(2, 9, 1),
(2, 10, 2),
(2, 11, 2),
(2, 12, 1),
-- Grilled Chicken Salad
(3, 12, 2),
(3, 13, 2),
(3, 14, 1),
(3, 15, 1),
(3, 16, 1),
(3, 6, 2),
-- Grilled Salmon Udon Soup
(4, 21, 2),
(4, 17, 1),
(4, 18, 1),
(4, 13, 1),
(4, 14, 2),
(4, 15, 2),
(4, 19, 1),
(4, 20, 1),
-- Chicken Cutlet Udon Soup
(5, 12, 2),
(5, 17, 1),
(5, 18, 1),
(5, 13, 1),
(5, 14, 2),
(5, 15, 2),
(5, 19, 1),
(5, 20, 1),
-- Pork Cutlet Udon Soup
(6, 22, 2),
(6, 17, 1),
(6, 18, 1),
(6, 13, 1),
(6, 14, 2),
(6, 15, 2),
(6, 19, 1),
(6, 20, 1),
-- Scallion Pie
(7, 20, 3),
(7, 23, 1),
-- Shumai (Deep Fried)
(8, 25, 6),
(8, 23, 1),
(8, 26, 1),
(8, 24, 1),
-- Shumai (Steamed)
(9, 25, 6),
(9, 23, 1),
(9, 26, 1),
-- Pork Gyoza (Pan Fried)
(10, 22, 6),
(10, 23, 1),
(10, 24, 1),
-- Pork Gyoza (Steamed)
(11, 22, 6),
(11, 23, 1),
-- POKE-Godzilla
(12, 21, 2),
(12, 27, 2),
(12, 1, 1),
(12, 28, 1),
(12, 29, 1),
(12, 10, 1),
(12, 30, 4),
-- POKE-Scorpion
(13, 27, 2),
(13, 31, 2),
(13, 2, 1),
(13, 1, 1),
(13, 29, 1),
(13, 10, 1),
(13, 30, 4),
-- POKE-Super Dragon
(14, 31, 2),
(14, 27, 2),
(14, 3, 2),
(14, 1, 1),
(14, 29, 1),
(14, 10, 1),
(14, 30, 4),
-- BURRITO-Caterpillar
(15, 27, 2),
(15, 1, 1),
(15, 2, 1),
(15, 9, 1),
(15, 29, 1),
(15, 10, 1),
(15, 30, 4),
-- BURRITO-Snow Mountain
(16, 31, 4),
(16, 3, 6),
(16, 4, 1),
(16, 9, 1),
(16, 10, 1),
(16, 30, 2),
-- BURRITO-Green Mile
(17, 21, 4),
(17, 1, 1),
(17, 9, 1),
(17, 31, 1),
(17, 10, 1),
(17, 30, 4),
-- Fried Baked Salmon
(18, 24, 3),
(18, 21, 2),
(18, 1, 1),
(18, 29, 1),
(18, 9, 1),
(18, 10, 1),
(18, 30, 4),
-- Fried Salmon Avocado
(19, 24, 3),
(19, 21, 3),
(19, 1, 1),
(19, 9, 1),
(19, 10, 1),
(19, 30, 4),
-- Fried Eel Avocado
(20, 24, 3),
(20, 27, 3),
(20, 1, 1),
(20, 9, 1),
(20, 10, 1),
(20, 30, 4),
-- California Maki
(21, 1, 1),
(21, 2, 1),
(21, 3, 4),
-- Shrimp Tempura Maki
(22, 1, 1),
(22, 2, 1),
(22, 31, 4),
(22, 29, 1),
-- Chicken Tempura Maki
(23, 1, 1),
(23, 32, 1),
(23, 12, 4),
(23, 29, 1),
-- My Sweet Day
(24, 33, 5),
(24, 1, 1),
(24, 34, 2),
(24, 3, 2),
(24, 6, 1),
-- Scorpion
(25, 27, 5),
(25, 1, 1),
(25, 2, 1),
(25, 31, 2),
(25, 29, 1),
-- Snow Mountain
(26, 31, 5),
(26, 3, 7),
(26, 4, 1),
(26, 6, 1),
-- Moley Crab
(27, 18, 4),
(27, 32, 4),
(27, 2, 2),
(27, 3, 2),
(27, 4, 1),
(27, 20, 1),
(27, 28, 1),
(27, 29, 1),
(27, 6, 1),
(27, 11, 1),
-- Super Dragon
(28, 31, 5),
(28, 1, 2),
(28, 3, 2),
(28, 27, 2),
(28, 29, 1),
-- Spicy Roll Platter
(29, 21, 4),
(29, 7, 4),
(29, 27, 4),
(29, 1, 3),
(29, 2, 3),
(29, 6, 3),
(29, 29, 3),
-- Donburi
(30, 27, 5),
(30, 30, 2),
(30, 2, 2),
(30, 6, 2),
(30, 4, 2),
-- Sashimi Combo
(31, 21, 9),
(31, 30, 5),
-- Oolong Tea
(32, 36, 1),
-- Green Tea
(33, 36, 1);

INSERT INTO favorite_menu_item (username, menu_item_id, liked_at)
VALUES
('dbenjamin',18,'2023-12-06 13:24:53'),
('dbenjamin',24,'2023-12-06 13:24:40'),
('dboyko',15,'2023-12-06 12:54:44'),
('dboyko',17,'2023-12-06 12:54:47'),
('dchernikov',17,'2023-12-06 12:12:47'),
('dchernikov',24,'2023-12-06 12:12:55'),
('dchoffnes',16,'2023-12-06 13:17:03'),
('dchoffnes',25,'2023-12-06 13:14:42'),
('dsmith',11,'2023-12-06 13:21:55'),
('dsmith',22,'2023-12-06 13:22:12'),
('mjump',12,'2023-12-06 13:18:41'),
('mjump',14,'2023-12-06 13:18:44'),
('pchernikov',13,'2023-12-06 12:49:40'),
('pchernikov',22,'2023-12-06 12:50:54'),
('vpavlu',3,'2023-12-06 13:09:02'),
('wfang',19,'2023-12-06 13:05:46'),
('wfang',31,'2023-12-06 13:03:54'),
('wfang',33,'2023-12-06 13:03:56');

INSERT INTO credit_card (number, holder, expiration_month, expiration_year)
VALUES
('1234432160199910','Dmitriy Chernikov',10,2027),
('1234432160197845','Dmitriy Chernikov',12,2025),
('4321789055128932','Pazin Tarasansombat',7,2024),
('1234432100176025','Dinara Boyko',2,2025),
('1234432175504913','Wenlin Fang',12,2026),
('1234432151098943','Wenlin Fang',6,2025),
('1234432151096517','Virgil Pavlu',10,2024),
('1234432151090019','Virgil Pavlu',10,2024),
('1234432151091084','David Choffnes',3,2028),
('1234432151075529','David Choffnes',12,2029),
('1234432151019900','Maria Jump',7,2025),
('1234432151017735','David Smith',2,2026),
('1234432151014208','Danny Benjamin',1,2025);

INSERT INTO account_credit_card (username, credit_card_id)
VALUES
('dchernikov',1),
('pchernikov',1),
('dchernikov',2),
('ptarasansombat',3),
('dboyko',4),
('wfang',5),
('wfang',6),
('vpavlu',7),
('vpavlu',8),
('dchoffnes',9),
('dchoffnes',10),
('mjump',11),
('dsmith',12),
('dbenjamin',13);

INSERT INTO payment (id, total, happened_at, credit_card_id)
VALUES
('069e80a004f3493b823df9f700e0c389',44.78,'2023-12-06 12:54:28',4),
('0855a233d2cc41b0bc3a35f2a948ba50',89.25,'2023-12-06 12:11:35',1),
('0cae806d854b4f609a7f5b667578b27a',20.02,'2023-12-06 12:17:50',2),
('205ae971ccce4190ba9e6a2bd41cbf50',28.14,'2023-12-06 13:15:32',9),
('251e6a1bd5a440cbaa7c1d1a26f44272',27.84,'2023-12-06 13:12:26',8),
('3e3e0a7958934f268fd8f17e934e7088',31.78,'2023-12-06 13:22:43',12),
('53813e08853e407193e6be13dbef7815',59.75,'2023-12-06 13:03:32',5),
('69d166019e0547f69f45ce0afa9e21ea',45.67,'2023-12-06 12:49:16',1),
('6aae6a7c71d848d9a0f39e777e2af7dd',42.03,'2023-12-06 13:05:28',6),
('7548e82ed7fa4ee19bf18037c98488c7',20.01,'2023-12-06 12:58:37',4),
('b662160fdb2a40e1a28aadad9a3399d7',43.76,'2023-12-06 13:17:16',10),
('b8a77f93f0024009a9c10b0282d64eed',18.01,'2023-12-06 13:09:38',7),
('bcaf712491294ef89edf411272bb576f',36.12,'2023-12-06 13:25:07',13),
('be1d1bdc98624393b2ca402f0ad9c5d1',20.02,'2023-12-06 12:36:35',3),
('d2fb1caa91b64918b92b9deda55b8104',17.15,'2023-12-06 12:38:31',3),
('e7240743ba6d4c8caf1f81fde86aa6e9',58.89,'2023-12-06 13:20:03',11),
('f5a664b572a441a78e837fe5fc7158fa',30.03,'2023-12-06 12:50:38',1);

INSERT INTO employee (first_name, last_name, salary, manager_id)
VALUES
('Adam', 'Silver', 10000000, NULL),
('Joseph', 'Mazzulla', 2500000, 1),
('Jason', 'Tatum', 32600060, 2),
('Jaylen', 'Brown', 52300000, 2),
('Jrue', 'Holiday', 39403894, 2),
('Al', 'Horford', 9500000, 2),
('Adrian', 'Griffin', 3889920, 1),
('Damian', 'Lillard', 45640084, 7),
('Brook', 'Lopez', 23000000, 7),
('Bobby', 'Portis', 10843350, 7),
('Giannis', 'Antetokounmpo', 48787676, 7);

INSERT INTO employee_schedule (employee_id, weekday, shift_from, shift_to)
VALUES
-- Silver Hours
(1, 1, '08:00:00', '16:00:00'),
(1, 2, '08:00:00', '16:00:00'),
(1, 3, '08:00:00', '16:00:00'),
(1, 4, '08:00:00', '16:00:00'),
(1, 5, '08:00:00', '16:00:00'),
-- Mazzulla
(2, 1, '00:00:00', '23:59:59'),
(2, 3, '00:00:00', '23:59:59'),
(2, 5, '00:00:00', '23:59:59'),
(2, 7, '00:00:00', '11:59:59'),
-- Griffin
(7, 2, '00:00:00', '23:59:59'),
(7, 4, '00:00:00', '23:59:59'),
(7, 6, '00:00:00', '23:59:59'),
(7, 7, '12:00:00', '23:59:59'),
-- Celtics Hours
(3, 1, '00:00:00', '11:59:59'),
(4, 1, '00:00:00', '11:59:59'),
(5, 1, '12:00:00', '23:59:59'),
(6, 1, '12:00:00', '23:59:59'),
(3, 3, '00:00:00', '11:59:59'),
(4, 3, '00:00:00', '11:59:59'),
(5, 3, '12:00:00', '23:59:59'),
(6, 3, '12:00:00', '23:59:59'),
(3, 5, '00:00:00', '11:59:59'),
(4, 5, '00:00:00', '11:59:59'),
(5, 5, '12:00:00', '23:59:59'),
(6, 5, '12:00:00', '23:59:59'),
(3, 7, '00:00:00', '11:59:59'),
(4, 7, '00:00:00', '11:59:59'),
(5, 7, '00:00:00', '11:59:59'),
(6, 7, '00:00:00', '11:59:59'),
-- Bucks Hours
(8, 2, '00:00:00', '11:59:59'),
(9, 2, '00:00:00', '11:59:59'),
(10, 2, '12:00:00', '23:59:59'),
(11, 2, '12:00:00', '23:59:59'),
(8, 4, '00:00:00', '11:59:59'),
(9, 4, '00:00:00', '11:59:59'),
(10, 4, '12:00:00', '23:59:59'),
(11, 4, '12:00:00', '23:59:59'),
(8, 6, '00:00:00', '11:59:59'),
(9, 6, '00:00:00', '11:59:59'),
(10, 6, '12:00:00', '23:59:59'),
(11, 6, '12:00:00', '23:59:59'),
(8, 7, '12:00:00', '23:59:59'),
(9, 7, '12:00:00', '23:59:59'),
(10, 7, '12:00:00', '23:59:59'),
(11, 7, '12:00:00', '23:59:59');

INSERT INTO online_order (created_at, completed_at, tip, payment_id, username, employee_id)
VALUES
('2023-12-06 12:11:35','2023-12-06 18:28:02',25.25,'0855a233d2cc41b0bc3a35f2a948ba50','dchernikov',5),
('2023-12-06 12:17:50','2023-12-06 18:28:02',2.02,'0cae806d854b4f609a7f5b667578b27a','dchernikov',5),
('2023-12-06 12:36:35','2023-12-06 18:28:02',4.02,'be1d1bdc98624393b2ca402f0ad9c5d1','ptarasansombat',5),
('2023-12-06 12:38:31','2023-12-06 18:28:02',2.15,'d2fb1caa91b64918b92b9deda55b8104','ptarasansombat',1),
('2023-12-06 12:49:16','2023-12-06 18:28:02',5.67,'69d166019e0547f69f45ce0afa9e21ea','pchernikov',5),
('2023-12-06 12:50:38','2023-12-06 18:28:02',3.03,'f5a664b572a441a78e837fe5fc7158fa','pchernikov',5),
('2023-12-06 12:54:27','2023-12-06 18:28:02',6.78,'069e80a004f3493b823df9f700e0c389','dboyko',1),
('2023-12-06 12:58:37','2023-12-06 18:28:02',2.01,'7548e82ed7fa4ee19bf18037c98488c7','dboyko',2),
('2023-12-06 13:03:32','2023-12-06 18:28:02',6.75,'53813e08853e407193e6be13dbef7815','wfang',6),
('2023-12-06 13:05:28','2023-12-06 18:28:02',3.03,'6aae6a7c71d848d9a0f39e777e2af7dd','wfang',6),
('2023-12-06 13:09:38','2023-12-06 18:28:02',2.01,'b8a77f93f0024009a9c10b0282d64eed','vpavlu',6),
('2023-12-06 13:12:26','2023-12-06 18:28:02',4.84,'251e6a1bd5a440cbaa7c1d1a26f44272','vpavlu',1),
('2023-12-06 13:15:32','2023-12-06 18:28:02',3.14,'205ae971ccce4190ba9e6a2bd41cbf50','dchoffnes',1),
('2023-12-06 13:17:16','2023-12-06 18:28:02',5.76,'b662160fdb2a40e1a28aadad9a3399d7','dchoffnes',2),
('2023-12-06 13:20:03','2023-12-06 18:28:02',6.89,'e7240743ba6d4c8caf1f81fde86aa6e9','mjump',6),
('2023-12-06 13:22:43','2023-12-06 18:28:02',4.78,'3e3e0a7958934f268fd8f17e934e7088','dsmith',1),
('2023-12-06 13:25:07','2023-12-06 18:28:02',3.12,'bcaf712491294ef89edf411272bb576f','dbenjamin',5);

INSERT INTO online_order_info (online_order_id, menu_item_id, quantity)
VALUES
(1,4,1),
(1,17,1),
(1,24,1),
(2,7,2),
(3,21,2),
(4,1,1),
(4,32,1),
(5,8,2),
(5,13,1),
(6,22,3),
(7,15,1),
(7,17,1),
(8,2,1),
(9,31,1),
(9,32,1),
(9,33,1),
(10,19,3),
(11,3,1),
(12,15,1),
(12,33,1),
(13,25,1),
(13,32,1),
(14,16,2),
(15,12,1),
(15,14,1),
(15,33,1),
(16,11,2),
(16,22,1),
(17,18,1),
(17,24,1);

COMMIT;