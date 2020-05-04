package springProjekat.in02projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springProjekat.in02projekat.entity.Korisnik;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

}
