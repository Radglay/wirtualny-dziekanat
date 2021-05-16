package oracle.project.demo.repository;

import oracle.project.demo.model.Pracownik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PracownikRepository extends JpaRepository<Pracownik, Long> {
}
