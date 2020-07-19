package springProjekat.in02projekat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springProjekat.in02projekat.entity.Korisnik;
import springProjekat.in02projekat.entity.Ocena;
import springProjekat.in02projekat.entity.dto.IdDTO;
import springProjekat.in02projekat.entity.dto.KorisnikLogovanjeDTO;
import springProjekat.in02projekat.entity.dto.OcenaIdDTO;
import springProjekat.in02projekat.entity.dto.OcenaKompletDTO;
import springProjekat.in02projekat.entity.dto.OcenaNaziviDTO;
import springProjekat.in02projekat.service.FilmService;
import springProjekat.in02projekat.service.KorisnikService;
import springProjekat.in02projekat.service.OcenaService;

@RestController
@RequestMapping(value = "/api/ocena")
public class OcenaController {
	
	private final OcenaService ocenaService;
	private final KorisnikService korisnikService;
	private final FilmService filmSerivice;
	@Autowired
	public OcenaController(OcenaService ocenaService, KorisnikService korisnikService, FilmService filmSerivice) {
		this.ocenaService = ocenaService;	
		this.korisnikService = korisnikService;
		this.filmSerivice = filmSerivice;
	}
	
	//kreiraj ocenu
	@PostMapping(
    		consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OcenaIdDTO> dodajOcenu(@RequestBody OcenaKompletDTO ocenapar) throws Exception{
		
		System.out.println(ocenapar);
		
		Ocena ocena = new Ocena(this.korisnikService.getByUsername(ocenapar.getUsername()), this.filmSerivice.getById(ocenapar.getidf()), ocenapar.getOcena());
		Ocena nova = this.ocenaService.create(ocena);
		return new ResponseEntity<>(new OcenaIdDTO(nova.getFilm().getId(), nova.getKorisnik().getId(), nova.getDataocena()), HttpStatus.OK);
	}
	//dobavi lisu ocena za dati id korisnika
	@PostMapping(
			value = ("/listanaid"),
    		consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OcenaKompletDTO>> listNaId(@RequestBody KorisnikLogovanjeDTO id){
		
		
		List<Ocena> ocene = this.ocenaService.getAll();
		Korisnik korisnik = this.korisnikService.getByUsername(id.getUsername());
		List<OcenaKompletDTO> ret = new ArrayList<>();
		for(Ocena ocena : ocene) {
			if(ocena.getKorisnik().getId() == korisnik.getId()) {
				ret.add(new OcenaKompletDTO(ocena.getId(), ocena.getFilm().getId(), ocena.getKorisnik().getId(), ocena.getKorisnik().getUsername(), ocena.getFilm().getNaziv(), ocena.getDataocena()));
			}
		}
		return new ResponseEntity<>(ret, HttpStatus.OK);
	}
	//izbrisi ocenu
	
	
	
}
