package springProjekat.in02projekat.service;

import java.util.List;

import springProjekat.in02projekat.entity.Korisnik;
import springProjekat.in02projekat.entity.dto.KorisnikLogovanjeDTO;

public interface KorisnikService {
	
    Korisnik create(Korisnik korisnik) throws Exception;
    
    List<Korisnik> findAll();
    List<Korisnik> findAllMenadzeri();
    Korisnik loginProvera(KorisnikLogovanjeDTO k);
    Korisnik getByUsername(String username);
    List<Korisnik> findAllNeaktivni();
    Korisnik aktiviraj(Long id);
    Korisnik findById(Long id);
    boolean ukloniKorisnika(Long id);
    void update(Korisnik korisnik);
}
