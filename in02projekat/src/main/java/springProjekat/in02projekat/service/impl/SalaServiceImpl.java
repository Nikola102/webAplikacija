package springProjekat.in02projekat.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springProjekat.in02projekat.entity.Sala;
import springProjekat.in02projekat.repository.SalaRepository;
import springProjekat.in02projekat.service.SalaService;

@Service
public class SalaServiceImpl implements SalaService {

	@Autowired
	private SalaRepository salaRepository;
	
	@Override
	public Sala create(Sala sala) throws Exception {
		if(sala.getId() != null)
			throw new Exception("id sale mora biti null");
		this.salaRepository.save(sala);
		return sala;
	}
	
	@Override
	public List<Sala> findAll() {
		return this.salaRepository.findAll();
	}
	
	@Override
	public List<Sala> findAllByBioskopId(Long id) {
		List<Sala> ret = new ArrayList<>(); 
		for(Sala sala : this.salaRepository.findAll()) 
			if(sala.getBioskop().getId() == id)
				ret.add(sala);
		return ret;
	}
	
	@Override
	public Sala findById(Long id) {
		return this.salaRepository.findById(id).get();
	}
	
	@Override
	public Sala update(Long id, Sala sala) {
		System.out.println("Id sale koja se menja: " +  id);
		Sala stara = this.salaRepository.findById(id).get();
		if(!sala.getOznaka().isEmpty())
			stara.setOznaka(sala.getOznaka());
		if(sala.getKapacitet() > 0)
			stara.setKapacitet(sala.getKapacitet());
		this.salaRepository.save(stara);
		return stara;
	}
	
	@Override
	public boolean obrisi(Long id) {
		if(id != null) {
			this.salaRepository.delete(this.salaRepository.findById(id).get());
			return true;
		}
		return false;
	}
	
}
