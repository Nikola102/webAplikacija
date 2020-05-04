INSERT INTO KORISNIK (username, password, name, surname, phonenumber, mail, birthday, role) VALUES ('nekoUserIme','nekiPassword', 'nekoIme', 'nekoPrezime', 065555555, 'user@gmail.com', '1999-01-01', 'Gledaoc');


INSERT INTO BIOSKOP(naziv, adresa, brojtelefona, email) VALUES ('Cinaplex', 'naCosku99', 0225555, 'cinaplex@gmail.com');
INSERT INTO SALA(kapacitet, oznaka, bioskop_id) VALUES (60, 'InfInz', 1);

INSERT INTO KORISNIK (username, password, name, surname, phonenumber, mail, birthday, role, bioskop_id) VALUES ('menadzer','nekiPassword', 'nekoIme', 'nekoPrezime', 065555555, 'user@gmail.com', '1999-01-01', 'Menadzer', 1);

INSERT INTO FILM(naziv, opis, zanr, trajanje, brojocena, srednjaocena) VALUES ('BiceSveURedu', 'nece', 'komedija-tragedija', 180, 1, 10);
INSERT INTO FILM(naziv, opis, zanr, trajanje, brojocena, srednjaocena) VALUES ('BiceSveURedu2', 'nece opet', 'komedija-tragedija', 192, 0, -1);

INSERT INTO KORISNIK_ODGLEDANO(korisnik_id, odgledano_id) VALUES('1', '1');
INSERT INTO KORISNIK_GLEDATI(korisnik_id, gledati_id) VALUES('1', '2');
INSERT INTO OCENA (dataocena, idfilm, idgledaoc) VALUES (10, 1, 1);

INSERT INTO TERMINSKA_LISTA_PROJEKCIJA (idfilm, idbioskop, idsala, date, brrezervacija) VALUES (2, 1, 1, '2020-06-06', 1);

INSERT INTO RASPORED_ODRZAVANJA_FILMOVA(idfilm, idbioskop, date, cena) VALUES (1, 1, '2020-06-06', 0);

