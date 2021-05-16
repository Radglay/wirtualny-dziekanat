package oracle.project.demo.repository;

import oracle.project.demo.model.Przedmiot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrzedmiotRepository extends JpaRepository<Przedmiot, Long> {
}
