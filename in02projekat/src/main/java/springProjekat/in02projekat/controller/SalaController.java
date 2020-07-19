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

import springProjekat.in02projekat.entity.Bioskop;
import springProjekat.in02projekat.entity.Korisnik;
import springProjekat.in02projekat.entity.Sala;
import springProjekat.in02projekat.entity.dto.IdDTO;
import springProjekat.in02projekat.entity.dto.KorisnikLogovanjeDTO;
import springProjekat.in02projekat.entity.dto.SalaDTO;
import springProjekat.in02projekat.service.BioskopService;
import springProjekat.in02projekat.service.KorisnikService;
import springProjekat.in02projekat.service.SalaService;

@RestController
@RequestMapping(value = "/api/sala")
public class SalaController {
	
	private final SalaService salaService;
	private final BioskopService bioskopService;
	private final KorisnikService korisnikService;
	@Autowired
	public SalaController(SalaService salaService, BioskopService bioskopService, KorisnikService korisnikService) {
		this.salaService = salaService;
		this.bioskopService = bioskopService;
		this.korisnikService = korisnikService;
	}
	
	//dodavanje
	@PostMapping(
		    consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE
			)
	private ResponseEntity<SalaDTO> kreirajSalu(@RequestBody SalaDTO info) throws Exception{
		Sala nova = new Sala(null, info.getKapacitet(), info.getOznaka(), this.bioskopService.findById(info.getIdb()), null);
		this.salaService.create(nova);
		return new ResponseEntity<>(new SalaDTO(nova.getId(), nova.getKapacitet(), nova.getOznaka(), nova.getBioskop().getId()), HttpStatus.OK);
	}
	//brisanje
	@PostMapping(
			value = ("/obrisi"),
		    consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE
			)
	private ResponseEntity<IdDTO> obrisi(@RequestBody IdDTO info) throws Exception {
		Sala sala = this.salaService.findById(info.getId());
		sala.setBioskop(null);
		this.salaService.update(info.getId(), sala);
		if(!this.salaService.obrisi(info.getId()))
			throw new Exception("nije obrisana sala sa id: " + info.getId());
		return new ResponseEntity<>(info ,HttpStatus.OK);
	}
	//izmena
	@PostMapping(
			value = ("/izmena"),
		    consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE
			)
	private ResponseEntity<SalaDTO> izmena(@RequestBody SalaDTO info) {
		Sala izmenjanja = new Sala(info.getId(), info.getKapacitet(), info.getOznaka(), null, null);
		System.out.println("id sale koja se menja: " + info.getId());
		Sala nova = this.salaService.update(info.getId(), izmenjanja);
		return new ResponseEntity<>(new SalaDTO(nova.getId(), nova.getKapacitet(), nova.getOznaka(), nova.getBioskop().getId()), HttpStatus.OK);
	}
	//litsa sala za bioskope u nadleznosti korisnika
	@PostMapping(
			value = ("/lista"),
		    consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE
			)
	private ResponseEntity<List<SalaDTO>> listaZaduzenja(@RequestBody KorisnikLogovanjeDTO info) {
		Korisnik korisnik = this.korisnikService.getByUsername(info.getUsername());
		List<SalaDTO> ret = new ArrayList<>();
		for(Bioskop bioskop : korisnik.getBioskopi()) 
			for(Sala sala : bioskop.getSale()) 
				ret.add(new SalaDTO(sala.getId(), sala.getKapacitet(), sala.getOznaka(),bioskop.getId()));
		return new ResponseEntity<>(ret, HttpStatus.OK);
	}
}
