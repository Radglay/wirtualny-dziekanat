package oracle.project.demo.repository;

import oracle.project.demo.model.Ocena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OcenaRepository extends JpaRepository<Ocena, Long> {

    @Query("select o from Ocena o where o.waga_oceny = :waga")
    Ocena findByWaga_oceny(Long waga);

}
