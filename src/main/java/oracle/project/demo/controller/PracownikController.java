package oracle.project.demo.controller;

import oracle.project.demo.model.Ocena;
import oracle.project.demo.model.Pracownik;
import oracle.project.demo.service.PracownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/pracownicy")
public class PracownikController {

    private final PracownikService pracownikService;

    @Autowired
    public PracownikController(PracownikService pracownikService) {
        this.pracownikService = pracownikService;
    }

    @GetMapping
    public List<Pracownik> getAll() {
        return pracownikService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Pracownik> getById(@PathVariable Long id) {
        return pracownikService.getById(id);
    }

    @PostMapping
    public Pracownik save(@RequestBody Pracownik pracownik) {
        return pracownikService.save(pracownik);
    }

    @DeleteMapping("/{id}")
    public Optional<Pracownik> delete(@PathVariable Long id) {
        return pracownikService.delete(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Pracownik> update(@PathVariable Long id, @RequestBody Pracownik pracownik) {
        return pracownikService.update(pracownik, id);
    }
}
