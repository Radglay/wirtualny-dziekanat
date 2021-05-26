package oracle.project.demo.controller;

import oracle.project.demo.model.Ocena;
import oracle.project.demo.model.TypZajec;
import oracle.project.demo.service.TypZajecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/typy-zajec")
public class TypZajecController {

    private final TypZajecService typZajecService;

    @Autowired
    public TypZajecController(TypZajecService typZajecService) {
        this.typZajecService = typZajecService;
    }

    @GetMapping
    public List<TypZajec> getAll() {
        return typZajecService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<TypZajec> getById(@PathVariable Long id) {
        return typZajecService.getById(id);
    }

    @PostMapping
    public TypZajec save(@RequestBody TypZajec typZajec) {
        return typZajecService.save(typZajec.getNazwa_typu_zajec());
    }

    @DeleteMapping("/{id}")
    public Optional<TypZajec> delete(@PathVariable Long id) {
        return typZajecService.delete(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TypZajec> update(@PathVariable Long id, @RequestBody TypZajec typZajec) {
        return typZajecService.update(typZajec, id);
    }
}
