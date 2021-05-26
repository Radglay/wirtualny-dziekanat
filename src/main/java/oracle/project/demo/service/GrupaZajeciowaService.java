package oracle.project.demo.service;

import oracle.project.demo.model.Dziedzina;
import oracle.project.demo.model.GrupaZajeciowa;
import oracle.project.demo.repository.GrupaZajeciowaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrupaZajeciowaService {

    private final GrupaZajeciowaRepository grupaZajeciowaRepository;

    @Autowired
    public GrupaZajeciowaService(GrupaZajeciowaRepository grupaZajeciowaRepository) {
        this.grupaZajeciowaRepository = grupaZajeciowaRepository;
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
        if(grupaZajeciowa.getCzas_zakonczenia().after(grupaZajeciowa.getCzas_rozpoczecia())) {
            if(nazwa != null && !nazwa.equals("")) {
                if(grupaZajeciowaRepository.findByNazwa_grupy_zajeciowej(nazwa).isEmpty()) {
                    //można utworzyć
                    grupaZajeciowaObj = grupaZajeciowaRepository.save(new GrupaZajeciowa(
                            grupaZajeciowa.getNazwa_grupy_zajeciowej(),
                            grupaZajeciowa.getCzas_rozpoczecia(),
                            grupaZajeciowa.getCzas_zakonczenia()
                    ));
                }
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
}
