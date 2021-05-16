package oracle.project.demo.repository;

import oracle.project.demo.model.Wydzial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WydzialRepository extends JpaRepository<Wydzial, Long> {
}
