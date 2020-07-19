package springProjekat.in02projekat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.*;
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
import springProjekat.in02projekat.entity.Ocena;
import springProjekat.in02projekat.entity.Sala;
import springProjekat.in02projekat.entity.TerminskaListaProjekcija;
import springProjekat.in02projekat.entity.dto.IdDTO;
import springProjekat.in02projekat.entity.dto.KorisnikLogovanjeDTO;
import springProjekat.in02projekat.entity.dto.PretragaParametriDTO;
import springProjekat.in02projekat.entity.dto.PretragaPovratnaDTO;
import springProjekat.in02projekat.entity.dto.SalaDTO;
import springProjekat.in02projekat.entity.dto.StringAndLongDTO;
import springProjekat.in02projekat.entity.dto.TLPKreiranjeDTO;
import springProjekat.in02projekat.entity.dto.TLPzaKarteDTO;
import springProjekat.in02projekat.service.FilmService;
import springProjekat.in02projekat.service.KorisnikService;
import springProjekat.in02projekat.service.OcenaService;
import springProjekat.in02projekat.service.SalaService;
import springProjekat.in02projekat.service.TerminskaListaProjekcijaService;


@RestController
@RequestMapping(value = "/api/terminkaListaProjekcija")
public class TerminskaListaProjekcijaController {
	private final TerminskaListaProjekcijaService terminskaListaProjekcijaService;
	private final FilmService filmService;
	private final SalaService salaService;
	private final KorisnikService korisnikService;
	private final OcenaService ocenaService;
	@Autowired
	public TerminskaListaProjekcijaController(TerminskaListaProjekcijaService terminskaListaProjekcijaSerivce, FilmService filmService, SalaService salaService, KorisnikService korisnikService, OcenaService ocenaService) {
		this.terminskaListaProjekcijaService = terminskaListaProjekcijaSerivce;
		this.filmService = filmService;
		this.salaService = salaService;
		this.korisnikService = korisnikService;
		this.ocenaService = ocenaService;
	}
	
	@GetMapping(
			value = ("/lista"),
    		produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TerminskaListaProjekcija>> geTterminskaListaProjekcija(){
		List<TerminskaListaProjekcija> listTLP = this.terminskaListaProjekcijaService.findAll();
		return new ResponseEntity<>(listTLP, HttpStatus.OK);
	}
	
	//dodaj
	@PostMapping(
		    consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<TLPKreiranjeDTO> dodaj(@RequestBody TLPKreiranjeDTO info) throws Exception{
		TerminskaListaProjekcija nova = new TerminskaListaProjekcija(this.filmService.getById(info.getIdf()), this.salaService.findById(info.getIds()), info.getCena(), info.getDatum());
		this.terminskaListaProjekcijaService.create(nova);
		return new ResponseEntity<>(info, HttpStatus.OK);
	}
	//obrisi
	@PostMapping(
			value = ("/obrisi"),
		    consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<IdDTO> obrisi (@RequestBody IdDTO info) throws Exception{
		if(!this.terminskaListaProjekcijaService.obrisi(info.getId()))
			throw new Exception("Ne bi trebao da je id null, obrisi kod TLP controller");
		return new ResponseEntity<>(info, HttpStatus.OK);
	}
	//rezervacija
	
	@PostMapping(
			value = ("/rezervacija"),
		    consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<StringAndLongDTO> rezervisi (@RequestBody StringAndLongDTO info) throws Exception{
		System.out.println(info);
		
		this.terminskaListaProjekcijaService.dodajRezervaciju(info.getNumber(), this.korisnikService.getByUsername(info.getString()));
		
		return new ResponseEntity<>(info, HttpStatus.OK);
	}
	
	
	@PostMapping(
			value = ("/listapomenadzeru"),
		    consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<List<TLPzaKarteDTO>> listajPoMenadzeru (@RequestBody KorisnikLogovanjeDTO info){
		List<TLPzaKarteDTO> tlps = new ArrayList<>();
		for(Bioskop bioskop : this.korisnikService.getByUsername(info.getUsername()).getBioskopi()) 
			for(Sala sala : bioskop.getSale()) 
				for(TerminskaListaProjekcija tlp : sala.getTerminskirasporedfilm())
					tlps.add(new TLPzaKarteDTO(tlp.getId(), tlp.getFilm().getNaziv(), sala.getOznaka(), bioskop.getNaziv(), tlp.getDate()));
		return new ResponseEntity<>(tlps, HttpStatus.OK);
	}
	
	@PostMapping(
			value = ("/pretraga"),
		    consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<List<PretragaPovratnaDTO>> trazi (@RequestBody PretragaParametriDTO info){
		List<PretragaPovratnaDTO> ret = new ArrayList<>();		
		for(TerminskaListaProjekcija tlp : this.terminskaListaProjekcijaService.findAll()) {
			PretragaPovratnaDTO nova = new PretragaPovratnaDTO();
			
			nova.setIdtlp(tlp.getId());
			nova.setBioskopNaziv(tlp.getSala().getBioskop().getNaziv());
			nova.setCena(tlp.getCena());
			nova.setNaziv(tlp.getFilm().getNaziv());
			nova.setSalaOznaka(tlp.getSala().getOznaka());
			nova.setTrajanje(tlp.getFilm().getTrajanje());
			nova.setVreme(tlp.getDate());
			nova.setZanr(tlp.getFilm().getZanr());
			double ocenaSrednja = 0;
			int saCimDeliti = 0;
			for(Ocena ocena : this.ocenaService.getByFilmId(tlp.getFilm().getId())) {
				if(ocena.getDataocena() > 0) {
					ocenaSrednja += ocena.getDataocena();
					saCimDeliti++;
				}
			}
			if(saCimDeliti == 0) {
				ocenaSrednja = 0;
			}
			else
				ocenaSrednja /= saCimDeliti;
			
			nova.setSrednjaOcena(ocenaSrednja) ;
			nova.setPreostalaMesta(tlp.getSala().getKapacitet() - tlp.getBrrezervacija());
			nova.setOdgovara(true);
			ret.add(nova);
		}
		if(info.getNaziv() != null) 
			for(PretragaPovratnaDTO pp : ret) 
				if(!pp.getNaziv().contains(info.getNaziv())) 
					pp.setOdgovara(false);
		if(info.getZanr() != null) 
			for(PretragaPovratnaDTO pp : ret) 
				if(!pp.getZanr().contains(info.getZanr())) 
					pp.setOdgovara(false);
		for(PretragaPovratnaDTO pp : ret) 
			if(pp.getCena() > info.getCena())
				pp.setOdgovara(false);
		if(info.getDatum() != null)
			for(PretragaPovratnaDTO pp : ret) 
				if(pp.getVreme().after(pp.getVreme()))
					pp.setOdgovara(false);
		
		List<PretragaPovratnaDTO> zasortiranje = new ArrayList<>();		
		for(PretragaPovratnaDTO pp : ret)
			if(pp.isOdgovara())
				zasortiranje.add(pp);
		
		switch (info.getTipSortiranja()) {
		case 1:
			for(int i = 0; i < zasortiranje.size(); i++) {
				for(int j = i; j < zasortiranje.size(); j++) {	
					if(zasortiranje.get(i).getNaziv().compareTo(zasortiranje.get(j).getNaziv()) > 0) {
						PretragaPovratnaDTO pom = new PretragaPovratnaDTO();
						pom.setWithOther(zasortiranje.get(i));
						zasortiranje.get(i).setWithOther(zasortiranje.get(j));
						zasortiranje.get(j).setWithOther(pom);
					}
				}
			}
			break;
		
		case 2:
			for(int i = 0; i < zasortiranje.size(); i++) {
				for(int j = i; j < zasortiranje.size(); j++) {	
					if(zasortiranje.get(i).getCena() > zasortiranje.get(j).getCena()) {
						PretragaPovratnaDTO pom = new PretragaPovratnaDTO();
						pom.setWithOther(zasortiranje.get(i));
						zasortiranje.get(i).setWithOther(zasortiranje.get(j));
						zasortiranje.get(j).setWithOther(pom);
					}
				}
			}
			break;
		case 3:
			for(int i = 0; i < zasortiranje.size(); i++) {
				for(int j = i; j < zasortiranje.size(); j++) {	
					if(zasortiranje.get(i).getSrednjaOcena() > zasortiranje.get(j).getSrednjaOcena()) {
						PretragaPovratnaDTO pom = new PretragaPovratnaDTO();
						pom.setWithOther(zasortiranje.get(i));
						zasortiranje.get(i).setWithOther(zasortiranje.get(j));
						zasortiranje.get(j).setWithOther(pom);
					}
				}
			}
			break;
		case 4:
			for(int i = 0; i < zasortiranje.size(); i++) {
				for(int j = i; j < zasortiranje.size(); j++) {	
					if(zasortiranje.get(i).getTrajanje() > zasortiranje.get(j).getTrajanje()){
						PretragaPovratnaDTO pom = new PretragaPovratnaDTO();
						pom.setWithOther(zasortiranje.get(i));
						zasortiranje.get(i).setWithOther(zasortiranje.get(j));
						zasortiranje.get(j).setWithOther(pom);
					}
				}
			}
			break;
			
		case 5:
			for(int i = 0; i < zasortiranje.size(); i++) {
				for(int j = i; j < zasortiranje.size(); j++) {	
					if(zasortiranje.get(i).getVreme().after(zasortiranje.get(j).getVreme())) {
						PretragaPovratnaDTO pom = new PretragaPovratnaDTO();
						pom.setWithOther(zasortiranje.get(i));
						zasortiranje.get(i).setWithOther(zasortiranje.get(j));
						zasortiranje.get(j).setWithOther(pom);
					}
				}
			}
			break;
		}
		
		
		return new ResponseEntity<>(zasortiranje, HttpStatus.OK);
	}
	
	
}
