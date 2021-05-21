package oracle.project.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GrupaZajeciowa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fk_id_grupy_zajeciowej;
    private String nazwa_grupy_zajeciowej;
    private Long fk_id_przedmiotu;

    public void setFk_id_grupy_zajeciowej(Long id_grupy_zajeciowej) {
        this.fk_id_grupy_zajeciowej = id_grupy_zajeciowej;
    }

    public void setNazwa_grupy_zajeciowej(String nazwa_grupy_zajeciowej) {
        this.nazwa_grupy_zajeciowej = nazwa_grupy_zajeciowej;
    }

    public void setFk_id_przedmiotu(Long id_przedmiotu) {
        this.fk_id_przedmiotu = id_przedmiotu;
    }

    public Long getFk_id_grupy_zajeciowej() {
        return fk_id_grupy_zajeciowej;
    }

    public String getNazwa_grupy_zajeciowej() {
        return nazwa_grupy_zajeciowej;
    }

    public Long getFk_id_przedmiotu() {
        return fk_id_przedmiotu;
    }

    public GrupaZajeciowa(String nazwa_grupy_zajeciowej, Long id_przedmiotu) {
        this.nazwa_grupy_zajeciowej = nazwa_grupy_zajeciowej;
        this.fk_id_przedmiotu = id_przedmiotu;
    }

    public GrupaZajeciowa() {
    }

    @Override
    public String toString() {
        return "GrupaZajeciowa{" +
                "id_grupy_zajeciowej=" + fk_id_grupy_zajeciowej +
                ", nazwa_grupy_zajeciowej='" + nazwa_grupy_zajeciowej + '\'' +
                ", id_przedmiotu=" + fk_id_przedmiotu +
                '}';
    }
}
