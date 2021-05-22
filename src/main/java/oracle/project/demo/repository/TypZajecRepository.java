package oracle.project.demo.repository;

import oracle.project.demo.model.TypZajec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TypZajecRepository extends JpaRepository<TypZajec, Long> {

    @Query("SELECT t FROM TypZajec t WHERE t.nazwa_typu_zajec = :nazwa")
    Optional<TypZajec> findTypZajecByNazwa_typu_zajec(@Param("nazwa") String nazwa);
}
