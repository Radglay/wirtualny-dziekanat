package oracle.project.demo.service;

import oracle.project.demo.model.TypZajec;
import oracle.project.demo.repository.TypZajecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypZajecService {
    private final TypZajecRepository typZajecRepository;

    @Autowired
    public TypZajecService(TypZajecRepository typZajecRepository) {
        this.typZajecRepository = typZajecRepository;
    }

    public List<TypZajec> getAll() {
        return typZajecRepository.findAll();
    }

    public Optional<TypZajec> getByNazwa(String nazwa) {
        Optional<TypZajec> typZajecObj = Optional.empty();
        if(nazwa != null && !nazwa.equals("")) {
            typZajecObj = this.typZajecRepository.findTypZajecByNazwa_typu_zajec(nazwa);
        }
        return typZajecObj;
    }

    public Optional<TypZajec> getById(Long id) {
        Optional<TypZajec> typZajecObj = Optional.empty();
        if(id != null && id > 0) {
            typZajecObj = typZajecRepository.findById(id);
        }

        return typZajecObj;
    }

    public TypZajec save(String nazwa) {
        TypZajec typZajecObj = null;
        if(this.getByNazwa(nazwa).isEmpty()) {
            //nie znaleziono
            typZajecObj = typZajecRepository.save(new TypZajec(nazwa));
        }

        return typZajecObj;
    }

    public Optional<TypZajec> delete(Long id) {
        Optional<TypZajec> typZajecObj = Optional.empty();
        if(id != null && id > 0) {
            if(typZajecRepository.existsById(id)) { //znaleziono
                typZajecObj = typZajecRepository.findById(id);
                typZajecRepository.deleteById(id);
            }
        }

        return typZajecObj;
    }
}
