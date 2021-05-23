package oracle.project.demo.service;

import oracle.project.demo.model.Pracownik;
import oracle.project.demo.repository.PracownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    public Optional<Pracownik> getById(Long id) {
        Optional<Pracownik> pracownikObj = Optional.empty();
        if(id != null && id > 0) {
            pracownikObj = pracownikRepository.findById(id);
        }

        return pracownikObj;
    }

    public Pracownik save(Pracownik pracownik) {
        Pracownik pracownikObj = null;
        String imie = pracownik.getImie_pracownika();
        String nazwisko = pracownik.getNazwisko_pracownika();
        if(imie != null && !imie.equals("")) {
            if(nazwisko != null && !nazwisko.equals("")) {
                if(pracownikRepository.findByImie_pracownikaAndAndNazwisko_pracownika(imie, nazwisko).isEmpty()) {
                    //można utworzyć
                    pracownikObj = pracownikRepository.save(new Pracownik(
                            imie, nazwisko
                    ));
                }
            }
        }

        return pracownikObj;
    }

    public Optional<Pracownik> delete(Long id) {
        Optional<Pracownik> pracownikObj = Optional.empty();

        if(id != null & id > 0) {
            if(pracownikRepository.existsById(id)) {
                //istnieje
                pracownikObj = pracownikRepository.findById(id);
                pracownikRepository.deleteById(id);
            }
        }

        return pracownikObj;
    }


}
