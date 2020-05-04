package springProjekat.in02projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springProjekat.in02projekat.entity.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {

}
