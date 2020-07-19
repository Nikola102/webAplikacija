package springProjekat.in02projekat.service;

import java.util.List;

import springProjekat.in02projekat.entity.Ocena;

public interface OcenaService {
	Ocena create(Ocena ocena) throws Exception;
	List<Ocena> getAll();
	List<Ocena> getByUserId(Long id);
	List<Ocena> getByFilmId(Long id);
}

