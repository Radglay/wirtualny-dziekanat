package oracle.project.demo.service;

import oracle.project.demo.model.Ocena;
import oracle.project.demo.model.Student;
import oracle.project.demo.repository.OcenaRepository;
import oracle.project.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        Optional<Student> studentObj = Optional.empty();
        if(id != null && id > 0) {
            studentObj = studentRepository.findById(id);
        }

        return studentObj;
    }

    public Student save(Student student) {
        Student studentObj = null;

        if(student.getImie_studenta() != null && !student.getImie_studenta().equals("")) {
            if(student.getNazwisko_studenta() != null && !student.getNazwisko_studenta().equals("")) {
                Optional<Student> studentRep = studentRepository.findStudentByImie_studentaAndNazwisko_studenta(
                        student.getImie_studenta(),
                        student.getNazwisko_studenta()
                );
                if(studentRep.isEmpty()) { //nie ma w bazie, dodajemy
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

}
