package oracle.project.demo.service;

import oracle.project.demo.model.GrupaZajeciowa;
import oracle.project.demo.model.Ocena;
import oracle.project.demo.model.Przedmiot;
import oracle.project.demo.model.Student;
import oracle.project.demo.repository.OcenaRepository;
import oracle.project.demo.repository.PracownikRepository;
import oracle.project.demo.repository.PrzedmiotRepository;
import oracle.project.demo.repository.StudentRepository;
import org.hibernate.engine.jdbc.cursor.internal.RefCursorSupportInitiator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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

    public Optional<Ocena> getById(Long id) {
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

    public Optional<Ocena> delete(Long id) {
        Optional<Ocena> ocenaObj = Optional.empty();
        if(id != null && id > 0) {
            if(ocenaRepository.existsById(id)) {
                //istnieje
                ocenaObj = ocenaRepository.findById(id);
                ocenaRepository.deleteById(id);
            }
        }

        return ocenaObj;
    }

    public ResponseEntity<Ocena> update(Ocena ocena, Long id) {
        Ocena ocenaObj = null;
        if(id != null && id > 0) {
            if(ocenaRepository.existsById(id)) {
                //istnieje
                ocenaObj =  ocenaRepository.findById(id).get();
                ocenaRepository.update(ocena.getWaga_oceny(), ocena.getWartosc(), id);
                return new ResponseEntity<Ocena>(ocenaObj, HttpStatus.OK);
            }
            //nie istnieje
            ocenaObj = this.save(ocena);
            return new ResponseEntity<Ocena>(ocenaObj, HttpStatus.CREATED);
        }

        return new ResponseEntity<Ocena>(HttpStatus.NOT_ACCEPTABLE);
    }




}
