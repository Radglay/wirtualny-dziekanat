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

    public Optional<Wydzial> getWydzialById(Long id) {
        Optional<Wydzial> wydzialObj = Optional.empty();
        if(id != null && id > 0) {
            wydzialObj = wydzialRepository.findById(id);
        }

        return wydzialObj;
    }
}
