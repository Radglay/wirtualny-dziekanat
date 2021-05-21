package oracle.project.demo.service;

import oracle.project.demo.model.GrupaZajeciowa;
import oracle.project.demo.repository.GrupaZajeciowaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrupaZajeciowaService {

    private final GrupaZajeciowaRepository grupaZajeciowaRepository;

    @Autowired
    public GrupaZajeciowaService(GrupaZajeciowaRepository grupaZajeciowaRepository) {
        this.grupaZajeciowaRepository = grupaZajeciowaRepository;
    }

    public List<GrupaZajeciowa> getAll() {
        return grupaZajeciowaRepository.findAll();
    }

    public Optional<GrupaZajeciowa> getGrupaZajeciowaById(Long id) {
        Optional<GrupaZajeciowa> grupaZajeciowaObj = Optional.empty();
        if(id != null && id > 0) {
            grupaZajeciowaObj = grupaZajeciowaRepository.findById(id);
        }

        return grupaZajeciowaObj;
    }

//    public GrupaZajeciowa save(GrupaZajeciowa grupaZajeciowa) {
//        GrupaZajeciowa grupaZajeciowaObj = null;
//        if(grupaZajeciowa.getId_przedmiotu()!= null && grupaZajeciowa.getId_przedmiotu() > 0) {
//
//        }
//    }
}
