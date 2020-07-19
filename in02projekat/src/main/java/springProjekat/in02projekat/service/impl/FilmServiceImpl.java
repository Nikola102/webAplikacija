package springProjekat.in02projekat.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import springProjekat.in02projekat.entity.Film;
import springProjekat.in02projekat.repository.FilmRepository;
import springProjekat.in02projekat.service.FilmService;

@Service
public class FilmServiceImpl implements FilmService {
	@Autowired
	private FilmRepository filmRepository;
	
	@Override
	public List<Film> findAll() {
		List<Film> filmovi = this.filmRepository.findAll();
		return filmovi;
	}
	
	@Override
	public Film getById(Long id) {
		return this.filmRepository.findById(id).get();
	}
}
