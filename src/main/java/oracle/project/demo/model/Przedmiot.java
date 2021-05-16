package oracle.project.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Przedmiot {
    @Id
    private Long id_przedmiotu;
    private String nazwa_przedmiotu;
    private Long id_pracownika;
    private Long id_zajec;

    public Long getId_przedmiotu() {
        return id_przedmiotu;
    }

    public void setId_przedmiotu(Long id_przedmiotu) {
        this.id_przedmiotu = id_przedmiotu;
    }

    public String getNazwa_przedmiotu() {
        return nazwa_przedmiotu;
    }

    public void setNazwa_przedmiotu(String nazwa_przedmiotu) {
        this.nazwa_przedmiotu = nazwa_przedmiotu;
    }

    public Long getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(Long id_pracownika) {
        this.id_pracownika = id_pracownika;
    }

    public Long getId_zajec() {
        return id_zajec;
    }

    public void setId_zajec(Long id_zajec) {
        this.id_zajec = id_zajec;
    }

    public Przedmiot(String nazwa_przedmiotu, Long id_pracownika, Long id_zajec) {
        this.nazwa_przedmiotu = nazwa_przedmiotu;
        this.id_pracownika = id_pracownika;
        this.id_zajec = id_zajec;
    }

    public Przedmiot() {
    }

    @Override
    public String toString() {
        return "Przedmiot{" +
                "id_przedmiotu=" + id_przedmiotu +
                ", nazwa_przedmiotu='" + nazwa_przedmiotu + '\'' +
                ", id_pracownika=" + id_pracownika +
                ", id_zajec=" + id_zajec +
                '}';
    }
}
