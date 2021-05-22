package oracle.project.demo.service;

import oracle.project.demo.model.Ocena;
import oracle.project.demo.model.Przedmiot;
import oracle.project.demo.model.Student;
import oracle.project.demo.repository.OcenaRepository;
import oracle.project.demo.repository.PracownikRepository;
import oracle.project.demo.repository.PrzedmiotRepository;
import oracle.project.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OcenaService {

    private final OcenaRepository ocenaRepository;
    private final StudentRepository studentRepository;
    private final PrzedmiotRepository przedmiotRepository;

    @Autowired
    public OcenaService(OcenaRepository ocenaRepository, StudentRepository studentRepository, PracownikRepository pracownikRepository, PrzedmiotRepository przedmiotRepository) {
        this.ocenaRepository = ocenaRepository;
        this.studentRepository = studentRepository;
        this.przedmiotRepository = przedmiotRepository;
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

    @Transactional
    public Ocena save(Ocena ocena) {
        Ocena ocenaObj = null;
        if(ocena.getWaga_oceny() > 0 && ocena.getWartosc() != null && !ocena.getWartosc().equals("")) {
            if(przedmiotRepository.existsById(ocena.getPrzedmiot().getId_przedmiotu())) { //przedmiot istnieje
                if(studentRepository.existsById(ocena.getStudent().getId()))  { //student istnieje
                    ocenaObj = ocenaRepository.save(new Ocena(
                            ocena.getWartosc(),
                            ocena.getWaga_oceny(),
                            przedmiotRepository.findById(ocena.getPrzedmiot().getId_przedmiotu()).get(),
                            studentRepository.findById(ocena.getStudent().getId()).get()
                    ));

                }
            }
        }

        return ocenaObj;
    }

}
