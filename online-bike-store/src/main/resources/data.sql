/*-- Insert roles
INSERT INTO role (id, name) VALUES (1, 'ROLE_ADMIN'), (2, 'ROLE_USER');

-- Insert users and assign roles
INSERT INTO user (username, password, role_id) VALUES
                                                   ('admin', '{bcrypt}hashed_admin_password', 1),
                                                   ('user', '{bcrypt}hashed_user_password', 2);


-- Insert roles if needed (skip this if roles were added manually)
INSERT INTO role (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO role (id, name) VALUES (2, 'ROLE_USER');

-- Insert categories
INSERT INTO category (id, name) VALUES
                                    (1, 'Mountain'),
                                    (2, 'Road'),
                                    (3, 'City'),
                                    (4, 'Electric');

-- Insert products organized by category
-- Mountain Bikes
INSERT INTO product (type, name, price, description, stock_quantity, category_id)
VALUES ('Mountain', 'Mountain Bike X1', 750.00, 'Durable mountain bike for rough terrains', 10, 1);

INSERT INTO product (type, name, price, description, stock_quantity, category_id)
VALUES ('Mountain', 'Mountain Bike X2', 850.00, 'Lightweight mountain bike for climbing', 8, 1);

INSERT INTO product (type, name, price, description, stock_quantity, category_id)
VALUES ('Mountain', 'Mountain Bike X3', 950.00, 'Advanced mountain bike with full suspension', 5, 1);

-- Road Bikes
INSERT INTO product (type, name, price, description, stock_quantity, category_id)
VALUES ('Road', 'Road Bike A1', 1200.00, 'High-speed road bike for smooth surfaces', 6, 2);

INSERT INTO product (type, name, price, description, stock_quantity, category_id)
VALUES ('Road', 'Road Bike A2', 1300.00, 'Lightweight road bike for long-distance rides', 4, 2);

INSERT INTO product (type, name, price, description, stock_quantity, category_id)
VALUES ('Road', 'Road Bike A3', 1400.00, 'Aerodynamic road bike for competitive racing', 3, 2);

-- City Bikes
INSERT INTO product (type, name, price, description, stock_quantity, category_id)
VALUES ('City', 'City Bike C1', 500.00, 'Comfortable bike ideal for commuting', 15, 3);

INSERT INTO product (type, name, price, description, stock_quantity, category_id)
VALUES ('City', 'City Bike C2', 550.00, 'Stylish city bike with convenient storage', 12, 3);

INSERT INTO product (type, name, price, description, stock_quantity, category_id)
VALUES ('City', 'City Bike C3', 600.00, 'Electric city bike with smooth handling', 10, 3);

-- Electric Bikes
INSERT INTO product (type, name, price, description, stock_quantity, category_id)
VALUES ('Electric', 'Electric Bike E1', 1800.00, 'Eco-friendly electric bike for city commutes', 5, 4);

INSERT INTO product (type, name, price, description, stock_quantity, category_id)
VALUES ('Electric', 'Electric Bike E2', 2000.00, 'Electric mountain bike for all-terrain travel', 4, 4);

INSERT INTO product (type, name, price, description, stock_quantity, category_id)
VALUES ('Electric', 'Electric Bike E3', 2200.00, 'Long-range electric bike with durable battery', 3, 4);

-- Create admin and user with hashed passwords (use plaintext if bcrypt is not enabled)
--INSERT INTO user (username, password, role_id) VALUES
--                                                   ('admin', '{bcrypt}$2a$10$hashed_password_for_admin', 1),
--                                                  ('user', '{bcrypt}$2a$10$hashed_password_for_user', 2);
////////////////////

-- Mountain Bikes
INSERT INTO product (type, name, price, description, stock_quantity, category_id, imageUrl)
VALUES ('Mountain', 'Mountain Bike X1', 750.00, 'Durable mountain bike for rough terrains', 10, 1, '/images/products/mountain_durable.webp');

INSERT INTO product (type, name, price, description, stock_quantity, category_id, imageUrl)
VALUES ('Mountain', 'Mountain Bike X2', 850.00, 'Lightweight mountain bike for climbing', 8, 1, '/images/products/mountain_lightweight.webp');
*/