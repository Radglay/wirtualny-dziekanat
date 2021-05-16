package oracle.project.demo.controller;

import oracle.project.demo.model.TypZajec;
import oracle.project.demo.service.TypZajecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/typy-zajec")
public class TypZajecController {

    private final TypZajecService typZajecService;

    @Autowired
    public TypZajecController(TypZajecService typZajecService) {
        this.typZajecService = typZajecService;
    }

    @GetMapping()
    public List<TypZajec> getAll() {
        return typZajecService.getAll();
    }

    @PostMapping()
    public TypZajec saveOne(@RequestParam String nazwa_typu_zajec) {
        return typZajecService.save(nazwa_typu_zajec);
    }
}
