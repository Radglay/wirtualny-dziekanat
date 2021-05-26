package oracle.project.demo.service;

import oracle.project.demo.model.Przedmiot;
import oracle.project.demo.repository.PrzedmiotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrzedmiotService {

    private final PrzedmiotRepository przedmiotRepository;

    @Autowired
    public PrzedmiotService(PrzedmiotRepository przedmiotRepository) {
        this.przedmiotRepository = przedmiotRepository;
    }

    public List<Przedmiot> getAll() {
        return przedmiotRepository.findAll();
    }

    public Optional<Przedmiot> getById(Long id) {
        Optional<Przedmiot> przedmiotObj = Optional.empty();
        if(id != null && id > 0) {
            przedmiotObj = przedmiotRepository.findById(id);
        }

        return przedmiotObj;
    }

    public Przedmiot save(Przedmiot przedmiot) {
        Przedmiot przedmiotObj = null;
        if(przedmiot.getNazwa_przedmiotu() != null && !przedmiot.getNazwa_przedmiotu().equals("")) {
                przedmiotObj = przedmiotRepository.save(new Przedmiot(
                        przedmiot.getNazwa_przedmiotu()
                ));
            }

        return przedmiotObj;
    }

    public Optional<Przedmiot> delete(Long id) {
        Optional<Przedmiot> przedmiotObj = Optional.empty();
        if(id != null && id > 0) {
            if(przedmiotRepository.existsById(id)) {
                //istnieje
                przedmiotObj = przedmiotRepository.findById(id);
                przedmiotRepository.deleteById(id);
            }
        }

        return przedmiotObj;
    }

    public ResponseEntity<Przedmiot> update(Przedmiot przedmiot, Long id) {
        Przedmiot przedmiotObj = null;
        if(id != null && id > 0) {
            if(przedmiotRepository.existsById(id)) {
                //istnieje
                przedmiotObj = przedmiotRepository.findById(id).get();
                przedmiotRepository.update(przedmiot.getNazwa_przedmiotu(), id);

                return new ResponseEntity<>(przedmiotObj, HttpStatus.OK);
            }
            przedmiotObj = this.save(przedmiot);
        }

        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

}
