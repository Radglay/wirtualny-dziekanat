package oracle.project.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @SequenceGenerator(name = "student_seq", sequenceName = "student_seq", initialValue = 1, allocationSize = 1)
    private Long id_studenta;
    private String imie_studenta;
    private String nazwisko_studenta;
    private String indeks_studenta;


    @OneToMany(mappedBy = "student")
    @JsonManagedReference
    private List<Ocena> oceny = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "studenci_grupy",
            joinColumns = @JoinColumn(name = "id_studenta"),
            inverseJoinColumns = @JoinColumn(name = "id_grupy_zajeciowej"))
    private Set<GrupaZajeciowa> grupyZajeciowe;

    public String getImie_studenta() {
        return imie_studenta;
    }

    public void setImie_studenta(String imie_studenta) {
        this.imie_studenta = imie_studenta;
    }

    public String getNazwisko_studenta() {
        return nazwisko_studenta;
    }

    public void setNazwisko_studenta(String nazwisko_studenta) {
        this.nazwisko_studenta = nazwisko_studenta;
    }

    public String getIndeks_studenta() {
        return indeks_studenta;
    }

    public void setIndeks_studenta(String indeks_studenta) {
        this.indeks_studenta = indeks_studenta;
    }

    public void setId(Long id_studenta) {
        this.id_studenta = id_studenta;
    }

    public Long getId() {
        return id_studenta;
    }

    public List<Ocena> getOceny() {
        return oceny;
    }

    public void setOceny(List<Ocena> oceny) {
        this.oceny = oceny;
    }

    public Set<GrupaZajeciowa> getGrupyZajeciowe() {
        return grupyZajeciowe;
    }

    public void setGrupyZajeciowe(Set<GrupaZajeciowa> grupyZajeciowe) {
        this.grupyZajeciowe = grupyZajeciowe;
    }

    public Student(String imie_studenta, String nazwisko_studenta, String indeks_studenta) {
        this.imie_studenta = imie_studenta;
        this.nazwisko_studenta = nazwisko_studenta;
        this.indeks_studenta = indeks_studenta;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID_STUDENTA=" + id_studenta +
                ", imie_studenta='" + imie_studenta + '\'' +
                ", nazwisko_studenta='" + nazwisko_studenta + '\'' +
                ", indeks_studenta='" + indeks_studenta + '\'' +
                '}';
    }
}
