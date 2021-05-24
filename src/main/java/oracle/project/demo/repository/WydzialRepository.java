package oracle.project.demo.repository;

import oracle.project.demo.model.Pracownik;
import oracle.project.demo.model.Wydzial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

public interface WydzialRepository extends JpaRepository<Wydzial, Long> {

    @Query("Select w from Wydzial w where w.nazwa_wydzialu = :nazwa_wydzialu")
    Optional<Wydzial> findByNazwa_wydzialu(@Param("nazwa_wydzialu") String nazwa_wydzialu);

    @Modifying
    @Transactional
    @Query("update Wydzial w set w.nazwa_wydzialu = :nazwa where w.id_wydzialu = :id")
    void update(@Param("nazwa") String nazwa, @Param("id") Long id);
}
