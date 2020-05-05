INSERT INTO KORISNIK (username, password, name, surname, phonenumber, mail, birthday, role) VALUES ('nekoUserIme','nekiPassword', 'nekoIme', 'nekoPrezime', 065555555, 'user@gmail.com', '1999-01-01', 'Gledaoc');


INSERT INTO BIOSKOP(naziv, adresa, brojtelefona, email) VALUES ('Cinaplex', 'naCosku99', 0225555, 'cinaplex@gmail.com');
INSERT INTO SALA(kapacitet, oznaka, bioskop_id) VALUES (60, 'InfInz', 1);

INSERT INTO KORISNIK (username, password, name, surname, phonenumber, mail, birthday, role, bioskop_id) VALUES ('menadzer','nekiPassword', 'nekoIme', 'nekoPrezime', 065555555, 'user@gmail.com', '1999-01-01', 'Menadzer', 1);

INSERT INTO FILM(naziv, opis, zanr, trajanje) VALUES ('BiceSveURedu', 'nece', 'komedija-tragedija', 180);
INSERT INTO FILM(naziv, opis, zanr, trajanje) VALUES ('BiceSveURedu2', 'nece opet', 'komedija-tragedija', 192);

INSERT INTO OCENA(DATAOCENA, FILM_ID, KORISNIK_ID) VALUES(10, 1, 1);
INSERT INTO RASPORED_ODRZAVANJA_FILMOVA (CENA ,DATE, BIOSKOP_ID, FILM_ID) VALUES (200, '2020-11-11', 1, 2);
INSERT INTO TERMINSKA_LISTA_PROJEKCIJA(BRREZERVACIJA, DATE) VALUES (1,  '2020-11-11')
INSERT INTO TERMINSKI_RAPORED_FILM (FILM_ID, LISTA_ID) VALUES (2, 1);
INSERT INTO TERMINSKI_RAPORED_SALA(SALA_ID, LISTA_ID) VALUES (1,1);
INSERT INTO BITI_ODGLEDANI(FILM_ID,KORISNIK_ID)VALUES(2,1);
INSERT INTO ODGLEDANI_FILMOVI(FILM_ID, KORISNIK_ID) VALUES (2,1);
