package oracle.project.demo.service;

import oracle.project.demo.model.Dziedzina;
import oracle.project.demo.repository.DziedzinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

}
