package oracle.project.demo.repository;

import oracle.project.demo.model.TypZajec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TypZajecRepository extends JpaRepository<TypZajec, Long> {

    @Query("SELECT t.id_typu_zajec, t.nazwa_typu_zajec FROM TypZajec t WHERE t.nazwa_typu_zajec = ?1")
    Optional<TypZajec> findTypZajecByNazwa_typu_zajec(@Param("nazwa") String nazwa);
}
