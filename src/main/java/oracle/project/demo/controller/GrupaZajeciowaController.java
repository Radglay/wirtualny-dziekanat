package oracle.project.demo.controller;

import oracle.project.demo.model.GrupaZajeciowa;
import oracle.project.demo.service.GrupaZajeciowaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/grupy-zajeciowe")
public class GrupaZajeciowaController {

    private final GrupaZajeciowaService grupaZajeciowaService;

    @Autowired
    public GrupaZajeciowaController(GrupaZajeciowaService grupaZajeciowaService) {
        this.grupaZajeciowaService = grupaZajeciowaService;
    }

    @GetMapping
    public List<GrupaZajeciowa> getAll() {
        return grupaZajeciowaService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<GrupaZajeciowa> getById(@PathVariable Long id) {
        return grupaZajeciowaService.getById(id);
    }

    @PostMapping
    public GrupaZajeciowa save(@RequestBody GrupaZajeciowa grupaZajeciowa) {
        return grupaZajeciowaService.save(grupaZajeciowa);
    }

    @DeleteMapping("/{id}")
    public Optional<GrupaZajeciowa> delete(@PathVariable Long id) {
        return grupaZajeciowaService.delete(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GrupaZajeciowa> update(@PathVariable Long id, @RequestBody GrupaZajeciowa grupaZajeciowa) {
        return grupaZajeciowaService.update(grupaZajeciowa, id);
    }
}
