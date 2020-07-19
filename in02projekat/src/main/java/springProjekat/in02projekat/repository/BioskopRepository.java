package springProjekat.in02projekat.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import springProjekat.in02projekat.entity.Bioskop;

public interface BioskopRepository extends JpaRepository<Bioskop, Long> {
	
	Optional<Bioskop> findById(Long id);
	
}
