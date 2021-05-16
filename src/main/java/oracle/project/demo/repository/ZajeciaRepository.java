package oracle.project.demo.repository;

import oracle.project.demo.model.Zajecia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZajeciaRepository extends JpaRepository<Zajecia, Long> {
}
