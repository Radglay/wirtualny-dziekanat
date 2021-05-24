package oracle.project.demo.controller;

import oracle.project.demo.model.Ocena;
import oracle.project.demo.service.OcenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/oceny")
public class OcenaController {

    private final OcenaService ocenaService;

    @Autowired
    public OcenaController(OcenaService ocenaService) {
        this.ocenaService = ocenaService;
    }

    @GetMapping
    public List<Ocena> getAll() {
        return ocenaService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Ocena> getById(@PathVariable Long id) {
        return ocenaService.getById(id);
    }

    @PostMapping
    public Ocena save(@RequestBody Ocena ocena) {
        return ocenaService.save(ocena);
    }

    @DeleteMapping("/{id}")
    public Optional<Ocena> delete(@PathVariable Long id) {
        return ocenaService.delete(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Ocena> update(@PathVariable Long id, @RequestBody Ocena ocena) {
        return ocenaService.update(ocena, id);
    }
}
