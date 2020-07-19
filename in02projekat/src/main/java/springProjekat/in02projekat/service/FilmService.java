package springProjekat.in02projekat.service;

import java.util.List;

import springProjekat.in02projekat.entity.Film;


public interface FilmService {
	
	List<Film> findAll();
	Film getById(Long id);
	
}
