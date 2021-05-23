package oracle.project.demo.controller;

import oracle.project.demo.model.Dziedzina;
import oracle.project.demo.service.DziedzinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/dziedziny")
public class DziedzinaController {

    private final DziedzinaService dziedzinaService;

    @Autowired
    public DziedzinaController(DziedzinaService dziedzinaService) {
        this.dziedzinaService = dziedzinaService;
    }

    @GetMapping
    public List<Dziedzina> getAll() {
        return dziedzinaService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Dziedzina> getById(@PathVariable Long id) {
        return dziedzinaService.getById(id);
    }

    @PostMapping
    public Dziedzina save(@RequestBody Dziedzina dziedzina) {
        return dziedzinaService.save(dziedzina);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Dziedzina> delete(@PathVariable Long id) {
        return dziedzinaService.delete(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Dziedzina> update(@PathVariable Long id, @RequestBody Dziedzina dziedzina) {
        return dziedzinaService.update(dziedzina, id);
    }

}
