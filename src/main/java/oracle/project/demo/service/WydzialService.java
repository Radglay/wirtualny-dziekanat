package oracle.project.demo.service;

import oracle.project.demo.model.Wydzial;
import oracle.project.demo.repository.WydzialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WydzialService {

    private final WydzialRepository wydzialRepository;

    @Autowired
    public WydzialService(WydzialRepository wydzialRepository) {
        this.wydzialRepository = wydzialRepository;
    }

    public List<Wydzial> getAll() {
        return wydzialRepository.findAll();
    }

    public Optional<Wydzial> getById(Long id) {
        Optional<Wydzial> wydzialObj = Optional.empty();
        if(id != null && id > 0) {
            wydzialObj = wydzialRepository.findById(id);
        }

        return wydzialObj;
    }

    public Wydzial save(Wydzial wydzial) {
        Wydzial wydzialObj = null;
        if(wydzial.getNazwa_wydzialu() != null && !wydzial.getNazwa_wydzialu().equals("")) {
            if(wydzialRepository.findByNazwa_wydzialu(wydzial.getNazwa_wydzialu()).isEmpty()) { //można tworzyć
                System.out.println(wydzialRepository.findByNazwa_wydzialu(wydzial.getNazwa_wydzialu()));
                wydzialObj = wydzialRepository.save(new Wydzial(wydzial.getNazwa_wydzialu()));
            }
        }

        return wydzialObj;
    }


    public Optional<Wydzial> delete(Long id) {
        Optional<Wydzial> wydzialObj = Optional.empty();
        if(id != null && id > 0) {
            if(wydzialRepository.existsById(id)) {
                wydzialObj = wydzialRepository.findById(id);
                wydzialRepository.deleteById(id);
            }
        }

        return wydzialObj;
    }
}
