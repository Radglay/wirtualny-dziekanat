package oracle.project.demo.service;

import oracle.project.demo.model.Przedmiot;
import oracle.project.demo.repository.PrzedmiotRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Optional<Przedmiot> getPrzedmiotById(Long id) {
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
}
