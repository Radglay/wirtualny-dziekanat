package oracle.project.demo.service;

import oracle.project.demo.model.Dziedzina;
import oracle.project.demo.repository.DziedzinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DziedzinaService {

    private final DziedzinaRepository dziedzinaRepository;

    @Autowired
    public DziedzinaService(DziedzinaRepository dziedzinaRepository) {
        this.dziedzinaRepository = dziedzinaRepository;
    }

    public List<Dziedzina> getAll() {
        return this.dziedzinaRepository.findAll();
    }

    public Optional<Dziedzina> getById(Long id) {
        return this.dziedzinaRepository.findById(id);
    }

    public Dziedzina save(Dziedzina dziedzina) {
        String nazwa = dziedzina.getNazwa_dziedziny();
        Dziedzina dziedzinaObj = null;
        if(nazwa != null && !nazwa.equals("")) {
            if(dziedzinaRepository.findByNazwa_dziedziny(nazwa).isEmpty()) {
                // nie znaleziono takiej dziedziny
                dziedzinaObj = dziedzinaRepository.save(new Dziedzina(nazwa));
            }
        }

        return dziedzinaObj;
    }

    public ResponseEntity<Dziedzina> delete(Long id) {
        Dziedzina dziedzinaObj = null;
        if(dziedzinaRepository.existsById(id)) { //istnieje
            dziedzinaObj = dziedzinaRepository.findById(id).get();
            dziedzinaRepository.deleteById(id);
            return new ResponseEntity<Dziedzina>(dziedzinaObj, HttpStatus.OK);
        }

        return new ResponseEntity<Dziedzina>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Dziedzina> update(Dziedzina dziedzina, Long id) {
        Dziedzina dziedzinaObj = null;
        if(id != 0 && id > 0) {
            if(dziedzinaRepository.findById(id).isPresent()) {
                //jeżeli istnieje w bazie, update
                dziedzinaRepository.update(dziedzina.getNazwa_dziedziny(), id);
                dziedzinaObj = dziedzinaRepository.findById(id).get();
                return new ResponseEntity<Dziedzina>(dziedzinaObj, HttpStatus.OK);
            }
            //nie ma w bazie
            dziedzinaObj = dziedzinaRepository.save(new Dziedzina(
                    dziedzina.getNazwa_dziedziny()
            ));
            return new ResponseEntity<Dziedzina>(dziedzinaObj, HttpStatus.CREATED);
        }

        return new ResponseEntity<Dziedzina>(HttpStatus.NOT_ACCEPTABLE);
    }
}
