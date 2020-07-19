package springProjekat.in02projekat.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springProjekat.in02projekat.entity.Ocena;
import springProjekat.in02projekat.repository.OcenaRepository;
import springProjekat.in02projekat.service.OcenaService;

@Service
public class OcenaServiceImpl implements OcenaService {
	
	@Autowired
	public OcenaRepository ocenaRepository;
	
	@Override
	public Ocena create(Ocena ocena) throws Exception {
		if(ocena.getId() != null) {
			throw new Exception("id ocene treba da je null");
		}
		this.ocenaRepository.save(ocena);
		return ocena;
	}
	
	@Override
	public List<Ocena> getAll() {
		return this.ocenaRepository.findAll();
	}
	
	@Override
	public List<Ocena> getByUserId(Long id) { 
		List<Ocena> ret = new ArrayList<>();
		
		for(Ocena ocena : this.ocenaRepository.findAll()) {
			if(ocena.getKorisnik().getId() == id) {
				ret.add(ocena);
			}
		}
		return ret;		
	}
	@Override
	public List<Ocena> getByFilmId(Long id) {
		List<Ocena> ret = new ArrayList<>();
		
		for(Ocena ocena : this.ocenaRepository.findAll()) {
			if(ocena.getFilm().getId() == id) {
				ret.add(ocena);
			}
		}
		return ret;	
	}

}
