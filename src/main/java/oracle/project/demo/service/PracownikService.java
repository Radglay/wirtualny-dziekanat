package oracle.project.demo.service;

import oracle.project.demo.model.Pracownik;
import oracle.project.demo.repository.PracownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PracownikService {

    private final PracownikRepository pracownikRepository;

    @Autowired
    public PracownikService(PracownikRepository pracownikRepository) {
        this.pracownikRepository = pracownikRepository;
    }

    public List<Pracownik> getAll() {
        return pracownikRepository.findAll();
    }

    public Optional<Pracownik> getPracownikById(Long id) {
        Optional<Pracownik> pracownikObj = Optional.empty();
        if(id != null && id > 0) {
            pracownikObj = pracownikRepository.findById(id);
        }

        return pracownikObj;
    }

}
