INSERT INTO hardware(code, name, type, amount, price) VALUES
    (1000, 'AMD Ryzen 5 3500X', 'CPU', 15, 139),
    (1001, 'AMD Ryzen 5 3600X', 'CPU', 200, 350),
    (1002, 'AMD Ryzen 5 5600X', 'CPU', 10, 750),
    (1003, 'Intel i9-9900K', 'CPU', 10, 1200);

INSERT INTO review(title, text, rating, hardwareid) VALUES
    ('Best CPU EVER!', 'THIS THING JUST SHREEEEDS!', 5, 1),
    ('Ok', 'Yeah alright.', 2, 1),
    ('Good', 'Pretty good CPU, would recommend.', 4, 2),
    ('Sucks.', 'Could not overclock to 7.5GHz, laaame.', 1, 2),
    ('Average', 'Average, expected better.', 3, 3),
    ('Good', 'Pretty good CPU, would recommend.', 4, 4);