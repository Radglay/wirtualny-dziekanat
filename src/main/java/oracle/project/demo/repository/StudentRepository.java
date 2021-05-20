package oracle.project.demo.repository;

import oracle.project.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.imie_studenta = ?1 AND s.nazwisko_studenta = ?2")
    Optional<Student> findStudentByImie_studentaAndNazwisko_studenta(@Param("imie") String imie, @Param("nazwisko") String nazwisko);
}
