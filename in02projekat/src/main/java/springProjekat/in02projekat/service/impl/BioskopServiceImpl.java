package springProjekat.in02projekat.service.impl;

import java.util.List;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springProjekat.in02projekat.entity.Bioskop;
import springProjekat.in02projekat.entity.Korisnik;
import springProjekat.in02projekat.entity.dto.BioskopZaListuDTO;
import springProjekat.in02projekat.repository.BioskopRepository;
import springProjekat.in02projekat.repository.KorisnikRepository;
import springProjekat.in02projekat.service.BioskopService;

@Service
public class BioskopServiceImpl implements BioskopService {

	@Autowired
	private BioskopRepository bioskopRepository;
	
	@Override
	public Bioskop create(Bioskop bioskop) throws Exception {
		if(bioskop.getId() != null) {
			throw new Exception ("Bioskop id must not be null");
		}
		Bioskop newBioskop = this.bioskopRepository.save(bioskop);
		return newBioskop;
	}
	
	@Override
	public List<Bioskop> findAll() {
		List<Bioskop> bioskopi = this.bioskopRepository.findAll();
		return bioskopi;
	}
	
	@Override
	public Bioskop update(BioskopZaListuDTO bzlDTO) {
		Bioskop bioskop = this.bioskopRepository.findById(bzlDTO.getId()).get();
		if(bzlDTO.getNaziv().length() > 1) {
			bioskop.setNaziv(bzlDTO.getNaziv());
		}
		if(bzlDTO.getBrojtelefona().length() > 1) {
			bioskop.setBrojTelefona(bzlDTO.getBrojtelefona());
		}
		if(bzlDTO.getAdresa().length() > 1) {
			bioskop.setAdresa(bzlDTO.getAdresa());
		}
		if(bzlDTO.getEmail().length() > 1) {
			bioskop.setEmail(bzlDTO.getEmail());
		}
		this.bioskopRepository.save(bioskop);
		return bioskop;
	}
	
	@Override
	public Bioskop findById(Long id) {
		Bioskop bioskop = this.bioskopRepository.findById(id).get();
		return bioskop;
	}
	
	@Override
	public void dodajMenadzera(Korisnik korisnik, Long idb) {
		Bioskop bioskop = this.bioskopRepository.findById(idb).get();
		bioskop.getMenadzeri().add(korisnik);
		this.bioskopRepository.save(bioskop);
	}
	
	@Override
	public boolean ukloniMenadzera(Korisnik korisnik, Long idb) {
		Bioskop bioskop = this.bioskopRepository.findById(idb).get();
		if(bioskop.getMenadzeri().size() == 1)
			return false;
		bioskop.getMenadzeri().remove(korisnik);
		this.bioskopRepository.save(bioskop);	
		return true;
	}
	
	@Override
	public void odbrisiBioskop(Long id) {
		this.bioskopRepository.delete(this.bioskopRepository.findById(id).get());
	}
	
}
