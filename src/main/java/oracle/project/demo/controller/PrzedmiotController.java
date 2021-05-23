package oracle.project.demo.controller;

import oracle.project.demo.model.Ocena;
import oracle.project.demo.model.Przedmiot;
import oracle.project.demo.service.PrzedmiotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/przedmioty")
public class PrzedmiotController {

    private final PrzedmiotService przedmiotService;

    @Autowired
    public PrzedmiotController(PrzedmiotService przedmiotService) {
        this.przedmiotService = przedmiotService;
    }

    @GetMapping
    public List<Przedmiot> getAll() {
        return przedmiotService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Przedmiot> getById(@PathVariable Long id) {
        return przedmiotService.getById(id);
    }

    @PostMapping
    public Przedmiot save(@RequestBody Przedmiot przedmiot) {
        return przedmiotService.save(przedmiot);
    }

    @DeleteMapping("/{id}")
    public Optional<Przedmiot> delete(@PathVariable Long id) {
        return przedmiotService.delete(id);
    }
}
