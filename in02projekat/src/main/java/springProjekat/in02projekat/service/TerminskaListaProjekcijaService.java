package springProjekat.in02projekat.service;

import java.util.List;

import springProjekat.in02projekat.entity.Korisnik;
import springProjekat.in02projekat.entity.TerminskaListaProjekcija;


public interface TerminskaListaProjekcijaService {
	List<TerminskaListaProjekcija> findAll();
	TerminskaListaProjekcija getById(Long id);
	void update(TerminskaListaProjekcija tlp);
	TerminskaListaProjekcija create(TerminskaListaProjekcija tlp) throws Exception;
	boolean obrisi(Long id);
	boolean dodajRezervaciju(Long id, Korisnik korisnik);
}
