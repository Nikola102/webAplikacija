package springProjekat.in02projekat.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springProjekat.in02projekat.entity.Bioskop;
import springProjekat.in02projekat.entity.Korisnik;
import springProjekat.in02projekat.entity.dto.BioskopDTO;
import springProjekat.in02projekat.entity.dto.BioskopZaListuDTO;
import springProjekat.in02projekat.entity.dto.IdDTO;
import springProjekat.in02projekat.entity.dto.OdnosiMenadzerBioskopDTO;
import springProjekat.in02projekat.service.BioskopService;
//import springProjekat.in02projekat.service.KorisnikService; //ne znam da li sme
//import springProjekat.in02projekat.service.impl.KorisnikServiceImpl;
import springProjekat.in02projekat.service.KorisnikService;


@RestController
@RequestMapping(value = "/api/bioskop")
public class BioskopController {
	
	private final BioskopService bioskopService;
	private final KorisnikService korisnikService;
	@Autowired
	public BioskopController(BioskopService bioskopService, KorisnikService korisnikService) {
		this.bioskopService = bioskopService;
		this.korisnikService = korisnikService;
	}
	
	@PostMapping( 
			consumes = MediaType.APPLICATION_JSON_VALUE,     
            produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BioskopDTO> createBioskop(@RequestBody BioskopDTO bioskopDTO)throws Exception {
		Bioskop bioskop = new Bioskop(bioskopDTO.getNaziv(), bioskopDTO.getAdresa(), bioskopDTO.getBrojtelefona(), bioskopDTO.getEmail());
		Set<Korisnik> menadzeri = new HashSet<>();
		
		System.out.println(bioskopDTO.getmenadzerusername());
		Korisnik korisnik = korisnikService.getByUsername(bioskopDTO.getmenadzerusername());
		
		menadzeri.add(korisnik);
		bioskop.setMenadzeri(menadzeri);
		Bioskop newBioskop = bioskopService.create(bioskop);
		BioskopDTO newBioskopDTO = new BioskopDTO(newBioskop.getNaziv(), newBioskop.getAdresa(), newBioskop.getBrojTelefona(), newBioskop.getEmail(), "0");
		return new ResponseEntity<>(newBioskopDTO, HttpStatus.OK);
	}
	
	@PostMapping(
			value = ("/izmeni"),
			consumes = MediaType.APPLICATION_JSON_VALUE,     
            produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BioskopZaListuDTO> izmeniBioskop(@RequestBody BioskopZaListuDTO bzlDTO){
		Bioskop novi = this.bioskopService.update(bzlDTO);
		
		BioskopZaListuDTO povratna = new BioskopZaListuDTO(novi.getId(), novi.getNaziv(), novi.getAdresa(), novi.getBrojTelefona(), novi.getEmail());
		
		return new ResponseEntity<>(povratna, HttpStatus.OK);
	}
	
	@GetMapping(
    		value = ("/lista"),
    		produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BioskopZaListuDTO>> getBioskopi(){
		List<Bioskop> bioskopi = this.bioskopService.findAll();
		List<BioskopZaListuDTO> bioskopDTOs = new ArrayList<>();
		
		for(Bioskop bioskop : bioskopi) {
			BioskopZaListuDTO bzlDTO = new BioskopZaListuDTO(bioskop.getId() ,bioskop.getNaziv(), bioskop.getAdresa(), bioskop.getBrojTelefona(), bioskop.getEmail());
			bioskopDTOs.add(bzlDTO);
		}
		
		return new ResponseEntity<>(bioskopDTOs, HttpStatus.OK);
	}
	
	@GetMapping(
    		value = ("/odnosi"),
    		produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OdnosiMenadzerBioskopDTO>> getOdnosi(){
		List<Bioskop> bioskopi = this.bioskopService.findAll();
		List<OdnosiMenadzerBioskopDTO> odnosi = new ArrayList<>();		
		for(Bioskop bioskop : bioskopi) 
			for(Korisnik korisnik : bioskop.getMenadzeri()) 
				odnosi.add(new OdnosiMenadzerBioskopDTO(bioskop.getId(), korisnik.getId()));
		return new ResponseEntity<>(odnosi, HttpStatus.OK);
	}
	
	@PostMapping(
			value = ("/dodajodnos"),
			consumes = MediaType.APPLICATION_JSON_VALUE,     
            produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OdnosiMenadzerBioskopDTO> dodajOdnos(@RequestBody OdnosiMenadzerBioskopDTO odnos) throws Exception{
		Korisnik korisnik = this.korisnikService.findById(odnos.getIdm());
		System.out.println("menadzer id " +korisnik.getId());	
		this.bioskopService.dodajMenadzera(korisnik, odnos.getIdb());
		
		return new ResponseEntity<>(odnos, HttpStatus.OK);
	}
	
	@PostMapping(
			value = ("/ukloniodnos"),
			consumes = MediaType.APPLICATION_JSON_VALUE,     
            produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OdnosiMenadzerBioskopDTO> ukloniOdnos(@RequestBody OdnosiMenadzerBioskopDTO odnos) throws Exception{
		Korisnik korisnik = this.korisnikService.findById(odnos.getIdm());
		System.out.println("menadzer id " +korisnik.getId());	
		boolean odg = this.bioskopService.ukloniMenadzera(korisnik, odnos.getIdb());
		if(odg == false)
			throw new Exception("Bioskop mora da ima bar 1 menadzera");
		return new ResponseEntity<>(odnos, HttpStatus.OK);
	}
	
	@PostMapping(
			value = ("/ukloni"),
			consumes = MediaType.APPLICATION_JSON_VALUE,     
            produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IdDTO> ukloniBioskop(@RequestBody IdDTO id) throws Exception{
		this.bioskopService.odbrisiBioskop(id.getId());
		
		
		return new ResponseEntity<>(id, HttpStatus.OK);
	}

}
