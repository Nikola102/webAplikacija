package springProjekat.in02projekat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springProjekat.in02projekat.entity.Korisnik;
import springProjekat.in02projekat.entity.TerminskaListaProjekcija;
import springProjekat.in02projekat.repository.TerminskaListaProjekcijaRepository;
import springProjekat.in02projekat.service.TerminskaListaProjekcijaService;

@Service
public class TerminskaListaProjekcijaServicImpl implements TerminskaListaProjekcijaService {
	
	@Autowired
	private TerminskaListaProjekcijaRepository terminskaListaProjekcijaRepository;

	@Override
	public List<TerminskaListaProjekcija> findAll() {
		return this.terminskaListaProjekcijaRepository.findAll();
	}
	
	@Override
	public TerminskaListaProjekcija getById(Long id) {
		return this.terminskaListaProjekcijaRepository.findById(id).get();
	}
	
	@Override
	public void update(TerminskaListaProjekcija tlp) {
		this.terminskaListaProjekcijaRepository.save(tlp);
	}
	
	@Override
	public TerminskaListaProjekcija create(TerminskaListaProjekcija tlp) throws Exception {
		if(tlp.getId() != null) {
			throw new Exception("Id must be not null za terminska lista");
		}
		this.terminskaListaProjekcijaRepository.save(tlp);
		return tlp;
	}
	
	@Override
	public boolean obrisi(Long id) {
		TerminskaListaProjekcija tlp = this.terminskaListaProjekcijaRepository.findById(id).get();
		tlp.setFilm(null);
		tlp.setSala(null);
		this.terminskaListaProjekcijaRepository.save(tlp);

		if(id != null) {
			this.terminskaListaProjekcijaRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean dodajRezervaciju(Long id, Korisnik korisnik) {
		if(id == null)
			return false;
		
		TerminskaListaProjekcija nova = this.terminskaListaProjekcijaRepository.findById(id).get();
		nova.getBuducikorisnici().add(korisnik);
		this.terminskaListaProjekcijaRepository.save(nova);
		return true;
	}
	
}
