INSERT INTO KORISNIK (username, password, name, surname, phonenumber, mail, birthday, role) VALUES ('nekoUserIme','nekiPassword', 'nekoIme', 'nekoPrezime', 065555555, 'user@gmail.com', '1999-01-01', 'Gledaoc');


INSERT INTO BIOSKOP(naziv, adresa, brojtelefona, email) VALUES ('Cinaplex', 'naCosku99', 0225555, 'cinaplex@gmail.com');
INSERT INTO SALA(kapacitet, oznaka, bioskop_id) VALUES (60, 'InfInz', 1);

INSERT INTO KORISNIK (username, password, name, surname, phonenumber, mail, birthday, role, bioskop_id) VALUES ('menadzer','nekiPassword', 'nekoIme', 'nekoPrezime', 065555555, 'user@gmail.com', '1999-01-01', 'Menadzer', 1);

INSERT INTO FILM(naziv, opis, zanr, trajanje) VALUES ('BiceSveURedu', 'nece', 'komedija-tragedija', 180);
INSERT INTO FILM(naziv, opis, zanr, trajanje) VALUES ('BiceSveURedu2', 'nece opet', 'komedija-tragedija', 192);



