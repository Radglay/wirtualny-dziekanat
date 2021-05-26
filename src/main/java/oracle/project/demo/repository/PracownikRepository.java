package oracle.project.demo.repository;

import oracle.project.demo.model.Pracownik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface PracownikRepository extends JpaRepository<Pracownik, Long> {

    @Query("select p from Pracownik p where p.imie_pracownika = :imie and p.nazwisko_pracownika = :nazwisko")
    Optional<Pracownik> findByImie_pracownikaAndAndNazwisko_pracownika(@Param("imie") String imie, @Param("nazwisko") String nazwisko);

    @Modifying
    @Transactional
    @Query("update Pracownik p set p.imie_pracownika = :imie, p.nazwisko_pracownika = :nazwisko where p.id_pracownika = :id" )
    void update(@Param("imie") String imie, @Param("nazwisko") String nazwisko, @Param("id") Long id);

}
