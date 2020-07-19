package springProjekat.in02projekat.service;

import java.util.List;

import springProjekat.in02projekat.entity.Sala;

public interface SalaService {
	
	Sala create(Sala sala) throws Exception;
	List<Sala> findAll();
	List<Sala> findAllByBioskopId(Long id);
	Sala findById(Long id);
	Sala update(Long id, Sala sala);
	boolean obrisi(Long id);
}
