package oracle.project.demo.repository;

import oracle.project.demo.model.Dziedzina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface DziedzinaRepository extends JpaRepository<Dziedzina, Long> {

    @Query("select d from Dziedzina d where d.nazwa_dziedziny = :nazwa")
    Optional<Dziedzina> findByNazwa_dziedziny(String nazwa);

    @Modifying
    @Transactional
    @Query(  "update Dziedzina d set d.nazwa_dziedziny = :nazwa where d.id_dziedziny = :id")
    void update(@Param("nazwa") String nazwa, @Param("id") Long id);
}
