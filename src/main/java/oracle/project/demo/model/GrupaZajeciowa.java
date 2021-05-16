package oracle.project.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GrupaZajeciowa {
    @Id
    private Long id_grupy_zajeciowej;
    private String nazwa_grupy_zajeciowej;
    private Long id_przedmiotu;

    public void setId_grupy_zajeciowej(Long id_grupy_zajeciowej) {
        this.id_grupy_zajeciowej = id_grupy_zajeciowej;
    }

    public void setNazwa_grupy_zajeciowej(String nazwa_grupy_zajeciowej) {
        this.nazwa_grupy_zajeciowej = nazwa_grupy_zajeciowej;
    }

    public void setId_przedmiotu(Long id_przedmiotu) {
        this.id_przedmiotu = id_przedmiotu;
    }

    public Long getId_grupy_zajeciowej() {
        return id_grupy_zajeciowej;
    }

    public String getNazwa_grupy_zajeciowej() {
        return nazwa_grupy_zajeciowej;
    }

    public Long getId_przedmiotu() {
        return id_przedmiotu;
    }

    public GrupaZajeciowa(String nazwa_grupy_zajeciowej, Long id_przedmiotu) {
        this.nazwa_grupy_zajeciowej = nazwa_grupy_zajeciowej;
        this.id_przedmiotu = id_przedmiotu;
    }

    public GrupaZajeciowa() {
    }

    @Override
    public String toString() {
        return "GrupaZajeciowa{" +
                "id_grupy_zajeciowej=" + id_grupy_zajeciowej +
                ", nazwa_grupy_zajeciowej='" + nazwa_grupy_zajeciowej + '\'' +
                ", id_przedmiotu=" + id_przedmiotu +
                '}';
    }
}
