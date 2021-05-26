package oracle.project.demo.controller;

import oracle.project.demo.model.Ocena;
import oracle.project.demo.model.Przedmiot;
import oracle.project.demo.model.Student;
import oracle.project.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/studenci")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Student> getById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @DeleteMapping("/{id}")
    public Optional<Student> delete(@PathVariable Long id) {
        return studentService.delete(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student) {
        return studentService.update(student, id);
    }

//    @GetMapping("/{id}")
//    public  getById(@PathVariable Long id) {
//        return studentService.procedureGetOceny(id);
//    }

    @PostMapping("/{id_studenta}/grupy-zajeciowe/{id_grupy}")
    public ResponseEntity<?> addGrupaZajeciowa(@PathVariable Long id_studenta, @PathVariable Long id_grupy) {
        return studentService.addGupaZajeciowa(id_studenta, id_grupy);
    }


}
