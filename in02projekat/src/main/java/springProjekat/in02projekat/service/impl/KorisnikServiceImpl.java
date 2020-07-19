package springProjekat.in02projekat.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springProjekat.in02projekat.entity.Korisnik;
import springProjekat.in02projekat.entity.dto.KorisnikLogovanjeDTO;
import springProjekat.in02projekat.repository.KorisnikRepository;
import springProjekat.in02projekat.service.KorisnikService;
import springProjekat.in02projekat.entity.Bioskop;;


@Service
public class KorisnikServiceImpl implements KorisnikService {
	@Autowired
	private KorisnikRepository korisnikRepository;
	
	@Override
	public Korisnik create(Korisnik korisnik) throws Exception {
		if(korisnik.getId() != null) {
			throw new Exception ("Korisnik id must be null: " + korisnik.getId());
		}
		System.out.println(korisnik.getUsername());
		Korisnik newKorisnik =  this.korisnikRepository.save(korisnik);
		
		return newKorisnik;
	}
	
	@Override
	public void update(Korisnik korisnik) {
		Korisnik neki = this.korisnikRepository.findById(korisnik.getId()).get();
		neki.setZagledati(korisnik.getZagledati());
		
		this.korisnikRepository.save(neki);
	}
	
	@Override
	public List<Korisnik> findAll() {
        List<Korisnik> korisnici= this.korisnikRepository.findAll();
        return korisnici;
	}
	
	@Override
	public Korisnik loginProvera(KorisnikLogovanjeDTO k) {
		System.out.println("ovo je iz login provera korisnik servise " + k);
		Korisnik korisnik = this.korisnikRepository.findByUsernameAndPassword(k.getUsername(), k.getPassword());
		//System.out.println(korisnik);
		return korisnik;
	}
	
	@Override
	public List<Korisnik> findAllMenadzeri() {
		return this.korisnikRepository.findByRoleAndActive("Menadzer", true);
	}
	
	@Override
	public Korisnik getByUsername(String username) {
		System.out.println(username);
		Korisnik korisnik = this.korisnikRepository.findByUsername(username);
		System.out.println("Iz getbyusername " + korisnik);
		return korisnik;
	}
	
	@Override
	public List<Korisnik> findAllNeaktivni() {
		List<Korisnik> menadzeri = this.korisnikRepository.findByRoleAndActive("Menadzer", false);
		return menadzeri;
	}
	
	@Override
	public Korisnik aktiviraj(Long id) {
		Korisnik korisnik = this.korisnikRepository.findById(id).get();
		korisnik.setActive(true);
		this.korisnikRepository.save(korisnik);
		return korisnik;
	}
	
	@Override
	public Korisnik findById(Long id) {
		Korisnik korisnik = this.korisnikRepository.findById(id).get();
		return korisnik;
	}
	
	@Override
	public boolean ukloniKorisnika(Long id) {
		System.out.println("id: " + id);
			for(Bioskop bioskop : this.korisnikRepository.findById(id).get().getBioskopi()) 
				if(bioskop.getMenadzeri().size() == 1)
					return false;
		this.korisnikRepository.delete(this.korisnikRepository.findById(id).get());
		return true;
	}
	
}
	