INSERT INTO stock.role (name) VALUES('ADMIN');
INSERT INTO stock.role (name) VALUES('CUSTOMER');
INSERT INTO stock.role (name) VALUES('USER');
INSERT INTO stock.role (name) VALUES('OWNER');

INSERT INTO stock.city (code, name) VALUES('34', 'İSTANBUL');
INSERT INTO stock.city (code, name) VALUES('01', 'ANKARA');
INSERT INTO stock.city (code, name) VALUES('38', 'KAYSERİ');

INSERT INTO stock.district (name, city_id) VALUES('ÜSKÜDAR', (select id from stock.city where name = 'İSTANBUL'));
INSERT INTO stock.district (name, city_id) VALUES('ÇANKAYA', (select id from stock.city where name = 'ANKARA'));
INSERT INTO stock.district (name, city_id) VALUES('PALANDÖKEN', (select id from stock.city where name = 'KAYSERİ'));