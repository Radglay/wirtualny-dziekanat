package oracle.project.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Pracownik {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pracownik_seq")
    @SequenceGenerator(name = "pracownik_seq", sequenceName = "pracownik_seq", initialValue = 1, allocationSize = 1)
    private Long id_pracownika;
    private String imie_pracownika;
    private String nazwisko_pracownika;


    @ManyToOne
    @JoinColumn(name = "id_wydzialu")
    private Wydzial wydzial;

    @ManyToOne
    @JoinColumn(name = "id_przedmiotu")
    private Przedmiot przedmiot;

    @ManyToMany
    @JoinTable(
            name = "pracownicy_grupy",
            joinColumns = @JoinColumn(name = "id_pracownika"),
            inverseJoinColumns = @JoinColumn(name = "id_grupy_zajeciowej"))
    private Set<GrupaZajeciowa> grupyZajeciowe;


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



    public Pracownik(String imie_pracownika, String nazwisko_pracownika) {
        this.imie_pracownika = imie_pracownika;
        this.nazwisko_pracownika = nazwisko_pracownika;
    }

    public Pracownik() {
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "id_pracownika=" + id_pracownika +
                ", imie_pracownika='" + imie_pracownika + '\'' +
                ", nazwisko_pracownika='" + nazwisko_pracownika + '\'' +
                '}';
    }
}
