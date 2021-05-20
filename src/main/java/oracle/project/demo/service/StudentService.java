package oracle.project.demo.service;

import oracle.project.demo.model.Student;
import oracle.project.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
