package oracle.project.demo.service;

import oracle.project.demo.model.TypZajec;
import oracle.project.demo.repository.TypZajecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public TypZajec save(String typZajec) {
        TypZajec typZajecObj = null;

        if(typZajec != null && !typZajec.equals("")) {
            if(!typZajecRepository.findTypZajecByNazwa_typu_zajec(typZajec).isPresent()) {
                //nie znaleziono
                typZajecObj = typZajecRepository.save(new TypZajec(typZajec));
            }
        }

        return typZajecObj;
    }
}
