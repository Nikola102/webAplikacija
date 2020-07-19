INSERT INTO KORISNIK (username, password, name, surname, phonenumber, mail, birthday, role, active) VALUES ('Nikola102','dobraSifra', 'Nikola', 'Matijevic', 060555666, 'user@gmail.com', '2000-02-29', 'Admin', true);

INSERT INTO KORISNIK (username, password, name, surname, phonenumber, mail, birthday, role, active) VALUES ('Marko123','nekiPassword', 'Marko', 'Markovic', 065555555, 'user@gmail.com', '2001-01-01', 'Gledaoc', true);


INSERT INTO BIOSKOP(naziv, adresa, brojtelefona, email) VALUES ('Cinaplex', 'naCosku99', 0225555, 'cinaplex@gmail.com');
INSERT INTO SALA(kapacitet, oznaka, bioskop_id) VALUES (60, 'InfInz', 1);

INSERT INTO KORISNIK (username, password, name, surname, phonenumber, mail, birthday, role, active) VALUES ('menadzer01','nekiPassword', 'Stefan', 'Stefanovic', 065775566, 'user@gmail.com', '1999-01-01', 'Menadzer', true);

INSERT INTO KORISNIK (username, password, name, surname, phonenumber, mail, birthday, role, active) VALUES ('menadzer02','nekiPassword', 'Petar', 'Stefanovic', 065775566, 'user@gmail.com', '1999-01-01', 'Menadzer', true);

INSERT INTO MENADZMENT (BIOSKOP_ID, KORISNIK_ID) VALUES (1, 3);

INSERT INTO FILM(naziv, opis, zanr, trajanje) VALUES ('BiceSveURedu', 'nece', 'komedija-tragedija', 180);
INSERT INTO FILM(naziv, opis, zanr, trajanje) VALUES ('BiceSveURedu2', 'nece opet', 'komedija-tragedija', 192);
INSERT INTO FILM(naziv, opis, zanr, trajanje) VALUES ('ABiceSveURedu2', 'koliko lose moze biti?', 'komedija-tragedija', 200);
INSERT INTO FILM(naziv, opis, zanr, trajanje) VALUES ('Terminator2', 'prvi deo', 'akcija', 180);
INSERT INTO FILM(naziv, opis, zanr, trajanje) VALUES ('Terminator1', 'vratio se', 'akcija', 180);
INSERT INTO FILM(naziv, opis, zanr, trajanje) VALUES ('Terminator3', 'vratio se2', 'akcija', 180);

INSERT INTO OCENA(DATAOCENA, FILM_ID, KORISNIK_ID) VALUES(10, 1, 2);
--INSERT INTO RASPORED_ODRZAVANJA_FILMOVA (CENA ,DATE, BIOSKOP_ID, FILM_ID) VALUES (200, '2020-11-11', 1, 2);

INSERT INTO ODGLEDANI_FILMOVI(FILM_ID, KORISNIK_ID) VALUES (4,2);
INSERT INTO ODGLEDANI_FILMOVI(FILM_ID, KORISNIK_ID) VALUES (5,2);

INSERT INTO ODGLEDANI_FILMOVI(FILM_ID, KORISNIK_ID) VALUES (2,2);
INSERT INTO TERMINSKA_LISTA_PROJEKCIJA (BRREZERVACIJA, DATE, CENA, FILM_ID, SALA_ID) VALUES(1, '2020-11-11', 250, 3, 1);
INSERT INTO TERMINSKA_LISTA_PROJEKCIJA (BRREZERVACIJA, DATE, CENA, FILM_ID, SALA_ID) VALUES(0, '2020-9-9', 300, 4, 1);
INSERT INTO TERMINSKA_LISTA_PROJEKCIJA (BRREZERVACIJA, DATE, CENA, FILM_ID, SALA_ID) VALUES(0, '2020-7-7', 350, 5, 1);
INSERT INTO BITI_ODGLEDANI  ( PROJEKCIJA_ID , KORISNIK_ID ) VALUES(1,1)
