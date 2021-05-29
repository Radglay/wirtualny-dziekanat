package oracle.project.demo.service;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import oracle.project.demo.model.GrupaZajeciowa;
import oracle.project.demo.model.Student;
import oracle.project.demo.repository.GrupaZajeciowaRepository;
import oracle.project.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final GrupaZajeciowaRepository grupaZajeciowaRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, GrupaZajeciowaRepository grupaZajeciowaRepository) {
        this.studentRepository = studentRepository;
        this.grupaZajeciowaRepository = grupaZajeciowaRepository;
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        Optional<Student> studentObj = Optional.empty();
        if (id != null && id > 0) {
            studentObj = studentRepository.findById(id);
        }

        return studentObj;
    }

    public Student save(Student student) {
        Student studentObj = null;

        if (student.getImie_studenta() != null && !student.getImie_studenta().equals("")) {
            if (student.getNazwisko_studenta() != null && !student.getNazwisko_studenta().equals("")) {
                Optional<Student> studentRep = studentRepository.findStudentByImie_studentaAndNazwisko_studenta(
                        student.getImie_studenta(),
                        student.getNazwisko_studenta()
                );
                if (studentRep.isEmpty()) { //nie ma w bazie, dodajemy
                    studentObj = studentRepository.save(new Student(
                            student.getImie_studenta(),
                            student.getNazwisko_studenta(),
                            student.getIndeks_studenta())
                    );
                }
            }
        }

        return studentObj;
    }

    public Optional<Student> delete(Long id) {
        Optional<Student> studentObj = Optional.empty();
        if (id != null && id > 0) {
            if (studentRepository.existsById(id)) {
                //istnieje
                studentObj = studentRepository.findById(id);
                studentRepository.deleteById(id);
            }
        }

        return studentObj;
    }

    public ResponseEntity<Student> update(Student student, Long id) {
        Student studentObj = null;
        if (id != null && id > 0) {
            if (studentRepository.existsById(id)) {
                //istnieje
                studentObj = studentRepository.findById(id).get();
                studentRepository.update(student.getImie_studenta(),
                        student.getNazwisko_studenta(),
                        student.getIndeks_studenta(),
                        id);
                return new ResponseEntity<>(studentObj, HttpStatus.OK);
            }
            studentObj = this.save(student);
            return new ResponseEntity<>(studentObj, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity<?> getOceny(Long id) throws SQLException, IOException {
        ResultSet resultSet = studentRepository.getOceny(id);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        //map result set to JSON
        List<Map<String, Object>> rows = new ArrayList<>();
        int numberOfColumns = resultSetMetaData.getColumnCount();

        while (resultSet.next()) {
            Map<String, Object> row = new HashMap<>();
            for (int i = 1; i <= numberOfColumns; i++) {
                String columnName = resultSetMetaData.getColumnName(i); //nazwa kolumny
                Object columnValue = resultSet.getObject(i);
                row.put(columnName, columnValue);
            }
            rows.add(row);
        }

        return new ResponseEntity<>(rows, HttpStatus.OK);
    }

    public ResponseEntity<?> addGupaZajeciowa(Long student_id, Long grupa_id) {
        Optional<GrupaZajeciowa> grupaZajeciowaObj = Optional.empty();
        if (grupa_id != null && grupa_id > 0) {
            if (grupaZajeciowaRepository.existsById(grupa_id)) {
                if (student_id != null && student_id > 0) {
                    if (studentRepository.existsById(student_id)) {
                        grupaZajeciowaObj = grupaZajeciowaRepository.findById(grupa_id);
                        studentRepository.addGrupaZajeciowa(student_id, grupa_id);
                        return new ResponseEntity<>(grupaZajeciowaObj, HttpStatus.OK);
                    }
                }
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

}
