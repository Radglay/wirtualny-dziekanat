package oracle.project.demo.controller;

import oracle.project.demo.model.Ocena;
import oracle.project.demo.service.OcenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public Ocena save(@RequestBody Ocena ocena) {
        return ocenaService.save(ocena);
    }
}
