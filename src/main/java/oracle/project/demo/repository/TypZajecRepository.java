package oracle.project.demo.repository;

import oracle.project.demo.model.TypZajec;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypZajecRepository extends JpaRepository<TypZajec, Long> {

    public Optional<TypZajec> findTypZajecByNazwa_typu_zajec(String nazwaTypuZajec);
}
