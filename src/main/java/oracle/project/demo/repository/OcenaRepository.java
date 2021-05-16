package oracle.project.demo.repository;

import oracle.project.demo.model.Ocena;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OcenaRepository extends JpaRepository<Ocena, Long> {
}
