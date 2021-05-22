package oracle.project.demo.controller;

import oracle.project.demo.model.Wydzial;
import oracle.project.demo.service.WydzialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/wydzialy")
public class WydzialController {

    private final WydzialService wydzialService;

    @Autowired
    public WydzialController(WydzialService wydzialService) {
        this.wydzialService = wydzialService;
    }

    @GetMapping
    public List<Wydzial> getAll() {
        return wydzialService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Wydzial> getById(@PathVariable Long id) {
        return wydzialService.getWydzialById(id);
    }

    @PostMapping
    public Wydzial save(@RequestBody Wydzial wydzial) {
         return wydzialService.save(wydzial);
    }

    @DeleteMapping("/{id}")
    public Optional<Wydzial> delete(@PathVariable Long id) {
        return wydzialService.delete(id);
    }
}
