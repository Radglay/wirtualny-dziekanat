package oracle.project.demo.controller;

import oracle.project.demo.model.Dziedzina;
import oracle.project.demo.service.DziedzinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/dziedziny")
public class DziedzinaController {

    private final DziedzinaService dziedzinaService;

    @Autowired
    public DziedzinaController(DziedzinaService dziedzinaService) {
        this.dziedzinaService = dziedzinaService;
    }

    @GetMapping()
    public List<Dziedzina> getAll() {
        return dziedzinaService.getAll();
    }

}
