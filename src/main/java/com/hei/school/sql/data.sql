INSERT INTO Product
    (name, price, creation_datetime)
VALUES
     ('Laptop Dell XPS', 4500.00, '2024-01-15 10:30:00'),
     ('Laptop Dell 13 XPS', 4520.00, '2024-01-15 14:10:00'),
     ('iPhone 13 WH1000', 820.00, '2024-02-01 16:45:00'),
     ('Casque Sony WH1000', 890.50, '2024-02-01 18:45:00'),
     ('Ecran Samsung 27"', 1200.00, '2024-03-08 00:00:00');

INSERT INTO Product_category
    (name, product_id)
VALUES
    ('Informatique', 1),
    ('Téléphonie', 2),
    ('Audio', 3),
    ('Accessoires', 4),
    ('Informatique', 5),
    ('Bureau', 5),
    ('Mobile', 2);