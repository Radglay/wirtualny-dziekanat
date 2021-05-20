package oracle.project.demo.service;

import oracle.project.demo.model.Ocena;
import oracle.project.demo.repository.OcenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OcenaService {

    private final OcenaRepository ocenaRepository;

    @Autowired
    public OcenaService(OcenaRepository ocenaRepository) {
        this.ocenaRepository = ocenaRepository;
    }

    public List<Ocena> getAll() {
        return ocenaRepository.findAll();
    }

    public Optional<Ocena> getOcenaById(Long id) {
        Optional<Ocena> ocenaObj = Optional.empty();
        if(id != null && id > 0) {
            ocenaObj = ocenaRepository.findById(id);
        }

        return ocenaObj;
    }
}
