package oracle.project.demo.service;

import oracle.project.demo.model.Zajecia;
import oracle.project.demo.repository.ZajeciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZajeciaService {

    private final ZajeciaRepository zajeciaRepository;

    @Autowired
    public ZajeciaService(ZajeciaRepository zajeciaRepository) {
        this.zajeciaRepository = zajeciaRepository;
    }

    public List<Zajecia> getAll() {
        return zajeciaRepository.findAll();
    }

    public Optional<Zajecia> getZajeciaById(Long id) {
        Optional<Zajecia> zajeciaObj = Optional.empty();
        if(id != null && id > 0) {
            zajeciaObj = zajeciaRepository.findById(id);
        }

        return zajeciaObj;
    }
}
