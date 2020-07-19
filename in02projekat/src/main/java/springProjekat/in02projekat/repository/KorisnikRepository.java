package springProjekat.in02projekat.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import springProjekat.in02projekat.entity.Korisnik;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

    Korisnik findByUsernameAndPassword(String username, String password);
    Korisnik findByUsername(String username);
	List<Korisnik> findByRoleAndActive (String role, boolean activity);
	Optional<Korisnik> findById(Long id);
	
}
