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

INSERT INTO user(username, password) VALUES
    ('Admin', '$2a$12$vhQlmjzb1aL1Lk0Ga4cWb.ry9ms.ZtNCY7mhkm5BEvmm1LSqjqXHm'),
    ('Filip', '$2a$12$gEfo4MrYLXUdq7mcYmc20e1D8hp2ogKARYD8ScXrAHqIZUE5Ao876'),
    ('Deleter', '$2a$12$sjIR/adk0KuLoeK4ne7NbeOlxUdK..VePFmkROwxLyinGYH3uwaUi');

INSERT INTO authority(authority_name) VALUES
    ('ROLE_ADMIN'),
    ('ROLE_USER'),
    ('ROLE_DELETER');

INSERT INTO user_authority(user_id, authority_id) VALUES
    (1L, 1L),
    (2L ,2L),
    (3L, 3L);