package oracle.project.demo.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import oracle.project.demo.model.GrupaZajeciowa;
import oracle.project.demo.service.GrupaZajeciowaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
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

    @PostMapping("/{id_grupy_zajeciowej}/przedmioty/{id_przedmiotu}")
    public ResponseEntity<?> addGrupaPrzedmiot(@PathVariable("id_grupy_zajeciowej") Long id_grupy_zajeciowej, @PathVariable("id_przedmiotu") Long id_przedmiotu,
                                                @RequestBody Map<String, String> data) throws ParseException {

        Date czas_rozpoczecia = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(data.get("czas_rozpoczecia"));
        System.out.println(czas_rozpoczecia);
        return grupaZajeciowaService.addGrupaPrzedmiot(id_grupy_zajeciowej, id_przedmiotu, czas_rozpoczecia);
    }

    @PostMapping("/divide-students")
    public ResponseEntity<?> divideStudents(@RequestBody Map<String, String> nazwa_grupy) {
        return grupaZajeciowaService.divideStudents(nazwa_grupy.get("nazwa_grupy"));
    }
}
