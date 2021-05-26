package oracle.project.demo.repository;

import oracle.project.demo.model.GrupaZajeciowa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

public interface GrupaZajeciowaRepository extends JpaRepository<GrupaZajeciowa, Long> {

    @Query("select gz from GrupaZajeciowa gz where gz.nazwa_grupy_zajeciowej = :nazwa")
    Optional<GrupaZajeciowa> findByNazwa_grupy_zajeciowej(@Param("nazwa") String nazwa);

    @Modifying
    @Transactional
    @Query("update GrupaZajeciowa gz set gz.nazwa_grupy_zajeciowej = :nazwa where gz.id_grupy_zajeciowej = :id")
    void update(@Param("nazwa") String nazwa, @Param("id") Long id);

}
