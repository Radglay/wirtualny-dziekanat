package oracle.project.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Przedmiot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_przedmiotu;
    private String nazwa_przedmiotu;
    private Long fk_id_pracownika;

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

    public Long getFk_id_pracownika() {
        return fk_id_pracownika;
    }

    public void setFk_id_pracownika(Long id_pracownika) {
        this.fk_id_pracownika = id_pracownika;
    }


    public Przedmiot(String nazwa_przedmiotu, Long id_pracownika) {
        this.nazwa_przedmiotu = nazwa_przedmiotu;
        this.fk_id_pracownika = id_pracownika;
    }

    public Przedmiot() {
    }

    @Override
    public String toString() {
        return "Przedmiot{" +
                "id_przedmiotu=" + id_przedmiotu +
                ", nazwa_przedmiotu='" + nazwa_przedmiotu + '\'' +
                ", id_pracownika=" + fk_id_pracownika +
                '}';
    }
}
