package springProjekat.in02projekat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import springProjekat.in02projekat.entity.Film;
import springProjekat.in02projekat.entity.Ocena;
import springProjekat.in02projekat.entity.dto.KorisnikLogovanjeDTO;
import springProjekat.in02projekat.service.FilmService;
import springProjekat.in02projekat.service.KorisnikService;
import springProjekat.in02projekat.service.OcenaService;


@RestController
@RequestMapping(value = "/api/film")
public class FilmController {
	
	private final FilmService filmService;
	private final KorisnikService korisnikService;
	private final OcenaService ocenaService;
	@Autowired
	public FilmController(FilmService filmService, KorisnikService korisnikService, OcenaService ocenaService) {
		this.filmService = filmService;
		this.korisnikService = korisnikService;
		this.ocenaService = ocenaService;
	}
	
	@GetMapping(
			value = ("/lista"),
    		produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Film>> getFilmovi(){
		List<Film> listaFilmova = this.filmService.findAll();
		return new ResponseEntity<>(listaFilmova, HttpStatus.OK);
	}
	
	@PostMapping(
			value = ("/listapoid"),
		    consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<List<Film>> getFilmoviZaKorisnika(@RequestBody KorisnikLogovanjeDTO klDTO){
		List<Film> retFilmovi = new ArrayList<>();
		
		for(Film film :this.korisnikService.getByUsername(klDTO.getUsername()).getOdgledano()) {
			retFilmovi.add(film);
		}
		
		return new ResponseEntity<>(retFilmovi, HttpStatus.OK);
	}
	
	@PostMapping(
			value = ("/listapoidbezocene"),
		    consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<List<Film>> getFilmoviZaKorisnikaBezOcene(@RequestBody KorisnikLogovanjeDTO klDTO){
		List<Ocena> dateOcene = this.ocenaService.getByUserId(this.korisnikService.getByUsername(klDTO.getUsername()).getId());
		List<Film> odgledani = new ArrayList<>();
		for(Film film : this.korisnikService.getByUsername(klDTO.getUsername()).getOdgledano()) {
			odgledani.add(film);
		}
		
		for(Ocena ocena : dateOcene) {
			odgledani.remove(ocena.getFilm());
		}
		
		for(Film film : odgledani) {
			System.out.println(film);
		}
		
		return new ResponseEntity<>(odgledani, HttpStatus.OK);
	}

	
}
