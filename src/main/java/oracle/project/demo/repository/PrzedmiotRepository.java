package oracle.project.demo.repository;

import oracle.project.demo.model.Pracownik;
import oracle.project.demo.model.Przedmiot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PrzedmiotRepository extends JpaRepository<Przedmiot, Long> {

        @Modifying
        @Transactional
        @Query("update Przedmiot p set p.nazwa_przedmiotu = :nazwa where p.id_przedmiotu = :id")
        void update(@Param("nazwa") String nazwa, @Param("id") Long id);
}
