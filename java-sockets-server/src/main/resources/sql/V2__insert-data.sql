INSERT INTO public.users (id, nick, login, password, insert_time)
VALUES (1, 'reven', 'dawid1', '$2a$12$DBUIoHN4y2gP61Rbqlu98enGgL/7/MT8Ui1XSktxvBjVlOVlJVKDW', DEFAULT);

INSERT INTO public.users (id, nick, login, password, insert_time)
VALUES (2, 'teddy', 'ted', '$2a$12$DBUIoHN4y2gP61Rbqlu98enGgL/7/MT8Ui1XSktxvBjVlOVlJVKDW', DEFAULT);

INSERT INTO public.vehicles (id, login, brand, model, insert_time)
VALUES (1, 'dawid1', 'Opel', 'Corsa', DEFAULT);

INSERT INTO public.vehicles (id, login, brand, model, insert_time)
VALUES (2, 'dawid1', 'Audi', 'A4', DEFAULT);

INSERT INTO public.vehicles (id, login, brand, model, insert_time)
VALUES (3, 'ted', 'BMW', 'M3', DEFAULT);

INSERT INTO public.insurance_offers (id, vehicle_id, insurer, price, insert_time)
VALUES (1, 1, 'AXA', 551.5, DEFAULT);

INSERT INTO public.insurance_offers (id, vehicle_id, insurer, price, insert_time)
VALUES (2, 1, 'Generali', 510, DEFAULT);

INSERT INTO public.insurance_offers (id, vehicle_id, insurer, price, insert_time)
VALUES (3, 2, 'PZU', 689.49, DEFAULT);



