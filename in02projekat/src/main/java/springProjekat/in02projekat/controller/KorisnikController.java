package springProjekat.in02projekat.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import springProjekat.in02projekat.entity.Bioskop;
import springProjekat.in02projekat.entity.Korisnik;
import springProjekat.in02projekat.entity.TerminskaListaProjekcija;
import springProjekat.in02projekat.entity.dto.KorisnikDTO;
import springProjekat.in02projekat.entity.dto.BioskopZaListuDTO;
import springProjekat.in02projekat.entity.dto.IdDTO;
import springProjekat.in02projekat.entity.dto.KorisnikLogovanjeDTO;
import springProjekat.in02projekat.entity.dto.KorisnikMenadzeriSveDTO;
import springProjekat.in02projekat.entity.dto.KorisnikNameLastnameUsernameDTO;
import springProjekat.in02projekat.entity.dto.KorisnikZaListuDTO;
import springProjekat.in02projekat.entity.dto.StringAndLongDTO;
import springProjekat.in02projekat.entity.dto.TLPzaKarteDTO;
import springProjekat.in02projekat.service.KorisnikService;
import springProjekat.in02projekat.service.TerminskaListaProjekcijaService;

@RestController
@RequestMapping(value = "/api/korisnik")
public class KorisnikController {

	private final KorisnikService korisnikService;
	private final TerminskaListaProjekcijaService terminskaListaProjekcijaService;
	@Autowired
	public KorisnikController(KorisnikService korisnikService, TerminskaListaProjekcijaService terminskaListaProjekcijaService) {
		this.korisnikService = korisnikService;
		this.terminskaListaProjekcijaService = terminskaListaProjekcijaService;
	}
	
	@PostMapping(
			value =("/login"),
		    consumes = MediaType.APPLICATION_JSON_VALUE,   
		    produces = MediaType.APPLICATION_JSON_VALUE)
			//produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KorisnikDTO> KorisnikLogin(@RequestBody KorisnikLogovanjeDTO korisnikLogovanjeDTO) throws Exception{
		Korisnik korisnik = this.korisnikService.loginProvera(korisnikLogovanjeDTO);
		if(korisnik == null) {
			throw new Exception("Kredincijali nisu tacni");
		}
		if(korisnik.getActive() == false) {
			throw new Exception("Nalog nije aktiviran");
		}
			
		System.out.println("ovo je iz korisnik login kontorler " + korisnik);
		KorisnikDTO korisnikDTO = new KorisnikDTO(korisnik.getId(), korisnik.getUsername(), "ne prenosim sifru", korisnik.getName(), korisnik.getSurname(), korisnik.getPhonenumber(), korisnik.getMail(), korisnik.getRole(), korisnik.getBirthday());
		return new ResponseEntity<>(korisnikDTO,HttpStatus.OK);
	}
	
	@PostMapping(
			value = ("/aktiviraj"),
		    consumes = MediaType.APPLICATION_JSON_VALUE,   
		    produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KorisnikNameLastnameUsernameDTO> aktivirajMenadzera(@RequestBody IdDTO id){
		System.out.println("Id onoga sto treba da se aktivira je: " + id.getId());
		Korisnik novi = this.korisnikService.aktiviraj(id.getId());
		
		KorisnikNameLastnameUsernameDTO povratni = new KorisnikNameLastnameUsernameDTO(novi.getName(), novi.getSurname(), novi.getSurname());
		
		return new ResponseEntity<>(povratni, HttpStatus.OK);
	}
	
    @GetMapping(
    		value = ("/lista"),
    		produces = MediaType.APPLICATION_JSON_VALUE)       // tip odgovora
    public ResponseEntity<List<KorisnikZaListuDTO>> getKorisnici() {
        List<Korisnik> korisnikList = this.korisnikService.findAll();

        List<KorisnikZaListuDTO> korisnikDTOS = new ArrayList<>();

        for (Korisnik korisnik: korisnikList) {
        	KorisnikZaListuDTO korisnikDTO = new KorisnikZaListuDTO(korisnik.getId(), korisnik.getName(), korisnik.getSurname(),
            		korisnik.getRole());
            korisnikDTOS.add(korisnikDTO);
        }
        return new ResponseEntity<>(korisnikDTOS, HttpStatus.OK);
    }			
	
    @GetMapping(
    		value = ("/neaktivni"),
    		produces = MediaType.APPLICATION_JSON_VALUE)       // tip odgovora
    public ResponseEntity<List<KorisnikZaListuDTO>> getNeaktivni() {
        List<Korisnik> korisnikList = this.korisnikService.findAllNeaktivni();

        List<KorisnikZaListuDTO> korisnikDTOS = new ArrayList<>();

        for (Korisnik korisnik: korisnikList) {
        	KorisnikZaListuDTO korisnikDTO = new KorisnikZaListuDTO(korisnik.getId(), korisnik.getName(), korisnik.getSurname(),
            		korisnik.getRole());
            korisnikDTOS.add(korisnikDTO);
        }
        return new ResponseEntity<>(korisnikDTOS, HttpStatus.OK);
    }
    
    @PostMapping( //registracijaKorisnika
            consumes = MediaType.APPLICATION_JSON_VALUE,     // tip podataka koje metoda može da primi
            produces = MediaType.APPLICATION_JSON_VALUE)     // tip odgovora
    public ResponseEntity<KorisnikDTO> createKorisnik(@RequestBody KorisnikDTO korisnikDTO) throws Exception {
    	boolean aktivan = true;
    	if(korisnikDTO.getRole().contains("Menadzer")) //treba da ga admin odobri
    		aktivan = false;
        Korisnik korisnik = new Korisnik(korisnikDTO.getUsername(), korisnikDTO.getPassword(), korisnikDTO.getName(), 
        		korisnikDTO.getSurname(), korisnikDTO.getPhonenumber(), korisnikDTO.getMail(), korisnikDTO.getBirthday(), korisnikDTO.getRole(), aktivan);
        		
        
        System.out.println("Salje se poruka iz korisnik kontrolera");
        System.out.println(korisnikDTO.getUsername());
        korisnikService.create(korisnik);
		
        return new ResponseEntity<>(korisnikDTO, HttpStatus.OK);
    }
    
    @GetMapping(
    		value = ("/menadzerisvi"),
    		produces = MediaType.APPLICATION_JSON_VALUE)       // tip odgovora
    public ResponseEntity<List<KorisnikZaListuDTO>> getMenadzeriSvi(){
    	List<Korisnik> menadzerList = this.korisnikService.findAllMenadzeri();
        List<KorisnikZaListuDTO> menadzeriDTOS = new ArrayList<>();
        for (Korisnik korisnik: menadzerList) {
        	KorisnikZaListuDTO korisnikDTO = new KorisnikZaListuDTO(korisnik.getId(), korisnik.getName(), korisnik.getSurname(), korisnik.getUsername());
        	menadzeriDTOS.add(korisnikDTO);
        }
        return new ResponseEntity<>(menadzeriDTOS, HttpStatus.OK);
    }
    
    @GetMapping(
    		value = ("/menadzeri"),
    		produces = MediaType.APPLICATION_JSON_VALUE)       // tip odgovora
    public ResponseEntity<List<KorisnikNameLastnameUsernameDTO>> getMenadzeri(){
    	List<Korisnik> menadzerList = this.korisnikService.findAllMenadzeri();
        List<KorisnikNameLastnameUsernameDTO> menadzeriDTOS = new ArrayList<>();
        for (Korisnik korisnik: menadzerList) {
        	KorisnikNameLastnameUsernameDTO korisnikDTO = new KorisnikNameLastnameUsernameDTO(korisnik.getName(), korisnik.getSurname(), korisnik.getUsername());
        	menadzeriDTOS.add(korisnikDTO);
        }
        return new ResponseEntity<>(menadzeriDTOS, HttpStatus.OK);
    }
    
    @GetMapping(
    		value = ("/menadzericeo"),
    		produces = MediaType.APPLICATION_JSON_VALUE)       // tip odgovora
    public ResponseEntity<List<KorisnikMenadzeriSveDTO>> getMenadzeriCeo(){
    	List<Korisnik> menadzerList = this.korisnikService.findAllMenadzeri();
        List<KorisnikMenadzeriSveDTO> menadzeriDTOS = new ArrayList<>();
        for (Korisnik korisnik: menadzerList) {
        	KorisnikMenadzeriSveDTO korisnikDTO = new KorisnikMenadzeriSveDTO(korisnik.getId(),korisnik.getName(), korisnik.getSurname(), korisnik.getUsername(), null);
        	menadzeriDTOS.add(korisnikDTO);
        }
        return new ResponseEntity<>(menadzeriDTOS, HttpStatus.OK);   
    }
    
    @PostMapping(
			value =("/ukloni"),
		    consumes = MediaType.APPLICATION_JSON_VALUE,   
		    produces = MediaType.APPLICATION_JSON_VALUE)
			//produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IdDTO> ukloniKorisnika(@RequestBody IdDTO id) throws Exception{
    	System.out.println("id da li je null?: " + id.getId());
		if(!(this.korisnikService.ukloniKorisnika(id.getId())))
			throw new Exception("Nekom bioskopu je jedinstven menadzer");
			
		return new ResponseEntity<>(id,HttpStatus.OK);
	}
    
    @PostMapping(
			value = ("/karte"),
    		consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TLPzaKarteDTO>> getKarte(@RequestBody KorisnikLogovanjeDTO kaoLogovanje){
		Korisnik korisnik = this.korisnikService.getByUsername(kaoLogovanje.getUsername());
		List<TLPzaKarteDTO> lista = new ArrayList<>();
		for(TerminskaListaProjekcija tlp : korisnik.getZagledati()) {	
			lista.add(new TLPzaKarteDTO(tlp.getId(), tlp.getFilm().getNaziv(), tlp.getSala().getOznaka(), tlp.getSala().getBioskop().getNaziv(), tlp.getDate()));
		}
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
    
    @PostMapping(
			value = ("/otkazivanje"),
    		consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IdDTO> otkazi(@RequestBody StringAndLongDTO parZaOtkazivanje) throws Exception{
		Korisnik korisnik = this.korisnikService.getByUsername(parZaOtkazivanje.getString());
		TerminskaListaProjekcija proba = this.terminskaListaProjekcijaService.getById(parZaOtkazivanje.getNumber());
		proba.getBuducikorisnici().remove(korisnik);
		this.terminskaListaProjekcijaService.update(proba);
		return new ResponseEntity<>(new IdDTO(parZaOtkazivanje.getNumber()), HttpStatus.OK);
	}
    
    @PostMapping(
			value = ("/bioskopzaduzenja"),
    		consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BioskopZaListuDTO>> bioskopZaduzenja(@RequestBody KorisnikLogovanjeDTO info) throws Exception{
		Korisnik korisnik = this.korisnikService.getByUsername(info.getUsername());
		List<BioskopZaListuDTO> ret = new ArrayList<>();
		
		for(Bioskop bioskop : korisnik.getBioskopi()) {
			ret.add(new BioskopZaListuDTO(bioskop.getId(), bioskop.getNaziv(), bioskop.getAdresa(), bioskop.getBrojTelefona(), bioskop.getEmail()));
		}
		
		return new ResponseEntity<>(ret, HttpStatus.OK);
	}
    
    
    
}
