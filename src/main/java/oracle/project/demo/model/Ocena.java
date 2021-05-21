package oracle.project.demo.model;

import javax.persistence.*;

@Entity
public class Ocena {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_oceny;
    private String wartosc;
    private Long fk_id_pracownika;
    private Long fk_id_studenta;
    private int waga_oceny;
    private Long fk_id_przedmiotu;

    public Long getId_oceny() {
        return id_oceny;
    }

    public void setId_oceny(Long id_oceny) {
        this.id_oceny = id_oceny;
    }

    public String getWartosc() {
        return wartosc;
    }

    public void setWartosc(String wartosc) {
        this.wartosc = wartosc;
    }

    public Long getFk_id_pracownika() {
        return fk_id_pracownika;
    }

    public void setFk_id_pracownika(Long id_pracownika) {
        this.fk_id_pracownika = id_pracownika;
    }

    public Long getFk_id_studenta() {
        return fk_id_studenta;
    }

    public void setFk_id_studenta(Long id_studenta) {
        this.fk_id_studenta = id_studenta;
    }

    public int getWaga_oceny() {
        return waga_oceny;
    }

    public void setWaga_oceny(int waga_oceny) {
        this.waga_oceny = waga_oceny;
    }

    public Long getFk_id_przedmiotu() {
        return fk_id_przedmiotu;
    }

    public void setFk_id_przedmiotu(Long id_przedmiotu) {
        this.fk_id_przedmiotu = id_przedmiotu;
    }

    public Ocena(String wartosc, Long id_pracownika, Long id_studenta, int waga_oceny, Long id_przedmiotu) {
        this.wartosc = wartosc;
        this.fk_id_pracownika = id_pracownika;
        this.fk_id_studenta = id_studenta;
        this.waga_oceny = waga_oceny;
        this.fk_id_przedmiotu = id_przedmiotu;
    }

    public Ocena() {
    }

    @Override
    public String toString() {
        return "Ocena{" +
                "id_oceny=" + id_oceny +
                ", wartosc='" + wartosc + '\'' +
                ", id_pracownika=" + fk_id_pracownika +
                ", id_studenta=" + fk_id_studenta +
                ", waga_oceny=" + waga_oceny +
                ", id_przedmiotu=" + fk_id_przedmiotu +
                '}';
    }
}
