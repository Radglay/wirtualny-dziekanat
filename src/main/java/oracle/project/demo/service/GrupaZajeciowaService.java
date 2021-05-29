package oracle.project.demo.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import oracle.project.demo.model.GrupaZajeciowa;
import oracle.project.demo.repository.GrupaZajeciowaRepository;
import oracle.project.demo.repository.PrzedmiotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GrupaZajeciowaService {

    private final GrupaZajeciowaRepository grupaZajeciowaRepository;
    private final PrzedmiotRepository przedmiotRepository;

    @Autowired
    public GrupaZajeciowaService(GrupaZajeciowaRepository grupaZajeciowaRepository, PrzedmiotRepository przedmiotRepository) {
        this.grupaZajeciowaRepository = grupaZajeciowaRepository;
        this.przedmiotRepository = przedmiotRepository;
    }

    public List<GrupaZajeciowa> getAll() {
        return grupaZajeciowaRepository.findAll();
    }

    public Optional<GrupaZajeciowa> getById(Long id) {
        Optional<GrupaZajeciowa> grupaZajeciowaObj = Optional.empty();
        if(id != null && id > 0) {
            grupaZajeciowaObj = grupaZajeciowaRepository.findById(id);
        }

        return grupaZajeciowaObj;
    }

    public GrupaZajeciowa save(GrupaZajeciowa grupaZajeciowa) {
        GrupaZajeciowa grupaZajeciowaObj = null;
        String nazwa = grupaZajeciowa.getNazwa_grupy_zajeciowej();
            if(nazwa != null && !nazwa.equals("")) {
                if(grupaZajeciowaRepository.findByNazwa_grupy_zajeciowej(nazwa).isEmpty()) {
                    //można utworzyć
                    grupaZajeciowaObj = grupaZajeciowaRepository.save(new GrupaZajeciowa(
                            grupaZajeciowa.getNazwa_grupy_zajeciowej()
                    ));
            }
        }

        return grupaZajeciowaObj;
    }

    public Optional<GrupaZajeciowa> delete(Long id) {
        Optional<GrupaZajeciowa> grupaZajeciowaObj = Optional.empty();

        if(id != null && id > 0) {
            if(grupaZajeciowaRepository.existsById(id)) {
                grupaZajeciowaObj = grupaZajeciowaRepository.findById(id);
                grupaZajeciowaRepository.deleteById(id);
            }
        }

        return grupaZajeciowaObj;
    }

    public ResponseEntity<GrupaZajeciowa> update(GrupaZajeciowa grupaZajeciowa, Long id) {
        GrupaZajeciowa grupaZajeciowaObj = null;
        if(id != null && id > 0) {
            if(grupaZajeciowaRepository.existsById(id)) {
                //istnieje
                grupaZajeciowaObj =  grupaZajeciowaRepository.findById(id).get();
                grupaZajeciowaRepository.update(grupaZajeciowa.getNazwa_grupy_zajeciowej(), id);
                return new ResponseEntity<GrupaZajeciowa>(grupaZajeciowaObj, HttpStatus.OK);
            }
            //nie istnieje
                grupaZajeciowaObj = this.save(grupaZajeciowa);
                return new ResponseEntity<GrupaZajeciowa>(grupaZajeciowaObj, HttpStatus.CREATED);
            }

            return new ResponseEntity<GrupaZajeciowa>(HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity<?> addGrupaPrzedmiot(Long id_grupy_zajeciowej, Long id_przedmiotu, Date czas_rozpoczecia) {
        if(grupaZajeciowaRepository.existsById(id_grupy_zajeciowej)) {
            if(przedmiotRepository.existsById(id_przedmiotu)) {
                //można dodać
                grupaZajeciowaRepository.addGrupaPrzedmiot(id_grupy_zajeciowej, id_przedmiotu, czas_rozpoczecia);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }


    public ResponseEntity<?> divideStudents(String nazwa_grupy) {
        grupaZajeciowaRepository.divideStudents(nazwa_grupy);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
