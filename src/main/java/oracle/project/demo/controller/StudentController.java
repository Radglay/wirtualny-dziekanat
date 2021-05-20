package oracle.project.demo.controller;

import oracle.project.demo.model.Student;
import oracle.project.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/studenci")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping()
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @PostMapping()
    public Student saveStudent(@RequestBody Student student) {
        return studentService.save(student);
    }
}
