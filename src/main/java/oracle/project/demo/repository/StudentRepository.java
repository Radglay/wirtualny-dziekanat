package oracle.project.demo.repository;

import oracle.project.demo.model.Pracownik;
import oracle.project.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.imie_studenta = ?1 AND s.nazwisko_studenta = ?2")
    Optional<Student> findStudentByImie_studentaAndNazwisko_studenta(@Param("imie") String imie, @Param("nazwisko") String nazwisko);

    @Modifying
    @Transactional
    @Query("update Student s set s.imie_studenta = :imie, s.nazwisko_studenta = :nazwisko, " +
            "s.indeks_studenta = :indeks where s.id_studenta = :id")
    void update(@Param("imie") String imie, @Param("nazwisko") String nazwisko,
                @Param("indeks") String indeks, @Param("id") Long id);


    @Procedure("PROCEDURE_ADD_GRUPA_ZAJECIOWA")
    void addGrupaZajeciowa(Long id_studenta, Long id_grupy);


    @Procedure(name = "Student.getOceny")
    ResultSet getOceny(@Param("id") Long id);
}
