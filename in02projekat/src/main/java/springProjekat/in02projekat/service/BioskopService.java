package springProjekat.in02projekat.service;

import java.util.List;

import springProjekat.in02projekat.entity.Bioskop;
import springProjekat.in02projekat.entity.Korisnik;
import springProjekat.in02projekat.entity.dto.BioskopZaListuDTO;

public interface BioskopService {
	
	Bioskop create(Bioskop bioskop) throws Exception;
	List<Bioskop> findAll();
	Bioskop update(BioskopZaListuDTO bzlDTO);
	Bioskop findById(Long id);
	void dodajMenadzera(Korisnik korisnik, Long idb);
	boolean ukloniMenadzera(Korisnik korisnik, Long idb);
	void odbrisiBioskop(Long id);
}
