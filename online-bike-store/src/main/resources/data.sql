/*
-- Insert roles

INSERT INTO role (id, name) VALUES
                                (1, 'ROLE_ADMIN'),
                                (2, 'ROLE_USER');

INSERT INTO category (id, name) VALUES
                                    (1, 'Mountain'),
                                    (2, 'Road'),
                                    (3, 'City'),
                                    (4, 'Electric');

-- Insert products
INSERT INTO product (type, name, price, description, stock_quantity, category_id, image_Url) VALUES
                                                                                                -- Mountain Bikes
                                                                                                ('Mountain', 'Mountain Bike X1', 750.00, 'Durable mountain bike for rough terrains', 10, 1, '/images/products/mountain_durable.webp'),
                                                                                               ('Mountain', 'Mountain Bike X2', 850.00, 'Lightweight mountain bike for climbing', 8, 1, '/images/products/mountain_lightweight.webp'),
                                                                                                ('Mountain', 'Mountain Bike X3', 950.00, 'Advanced mountain bike with full suspension', 5, 1, null),

                                                                                                -- Road Bikes
                                                                                                ('Road', 'Road Bike A1', 1200.00, 'High-speed road bike for smooth surfaces', 6, 2, null),
                                                                                                ('Road', 'Road Bike A2', 1300.00, 'Lightweight road bike for long-distance rides', 4, 2, null),
                                                                                                ('Road', 'Road Bike A3', 1400.00, 'Aerodynamic road bike for competitive racing', 3, 2, null),

                                                                                                -- City Bikes
                                                                                                ('City', 'City Bike C1', 500.00, 'Comfortable bike ideal for commuting', 15, 3, null),
                                                                                                ('City', 'City Bike C2', 550.00, 'Stylish city bike with convenient storage', 12, 3, null),
                                                                                                ('City', 'City Bike C3', 600.00, 'Electric city bike with smooth handling', 10, 3, null),

                                                                                                -- Electric Bikes
                                                                                                ('Electric', 'Electric Bike E1', 1800.00, 'Eco-friendly electric bike for city commutes', 5, 4, null),
                                                                                                ('Electric', 'Electric Bike E2', 2000.00, 'Electric mountain bike for all-terrain travel', 4, 4, null),
                                                                                                ('Electric', 'Electric Bike E3', 2200.00, 'Long-range electric bike with durable battery', 3, 4, null);
*/

