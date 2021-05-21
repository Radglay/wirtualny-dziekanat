package oracle.project.demo.model;

import javax.persistence.*;

@Entity
public class Pracownik {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_pracownika;
    private String imie_pracownika;
    private String nazwisko_pracownika;

    @ManyToOne
    @JoinColumn(name = "id_wydzialu")
    private Wydzial wydzial;

    private Long fk_id_wydzialu;
    private Long id_dziedziny;

    public Long getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(Long id_pracownika) {
        this.id_pracownika = id_pracownika;
    }

    public String getImie_pracownika() {
        return imie_pracownika;
    }

    public void setImie_pracownika(String imie_pracownika) {
        this.imie_pracownika = imie_pracownika;
    }

    public String getNazwisko_pracownika() {
        return nazwisko_pracownika;
    }

    public void setNazwisko_pracownika(String nazwisko_pracownika) {
        this.nazwisko_pracownika = nazwisko_pracownika;
    }

    public Long getFk_id_wydzialu() {
        return fk_id_wydzialu;
    }

    public void setFk_id_wydzialu(Long id_wydzialu) {
        this.fk_id_wydzialu = id_wydzialu;
    }

    public Long getId_dziedziny() {
        return id_dziedziny;
    }

    public void setId_dziedziny(Long id_dziedziny) {
        this.id_dziedziny = id_dziedziny;
    }

    public Pracownik(String imie_pracownika, String nazwisko_pracownika, Long id_wydzialu, Long id_dziedziny) {
        this.imie_pracownika = imie_pracownika;
        this.nazwisko_pracownika = nazwisko_pracownika;
        this.fk_id_wydzialu = id_wydzialu;
        this.id_dziedziny = id_dziedziny;
    }

    public Pracownik() {
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "id_pracownika=" + id_pracownika +
                ", imie_pracownika='" + imie_pracownika + '\'' +
                ", nazwisko_pracownika='" + nazwisko_pracownika + '\'' +
                ", id_wydzialu=" + fk_id_wydzialu +
                ", id_dziedziny=" + id_dziedziny +
                '}';
    }
}
