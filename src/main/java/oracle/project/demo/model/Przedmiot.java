package oracle.project.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Przedmiot {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "przedmiot_seq")
    @SequenceGenerator(name = "przedmiot_seq", sequenceName = "przedmiot_seq", initialValue = 1, allocationSize = 1)
    private Long id_przedmiotu;
    private String nazwa_przedmiotu;

    @OneToMany(mappedBy = "przedmiot")
    private List<Ocena> oceny = new ArrayList<>();;

    @OneToMany(mappedBy = "przedmiot")
    private List<Pracownik> pracownicy = new ArrayList<>();;

    @ManyToMany
    @JoinTable(
            name = "grupy_przedmioty",
            joinColumns = @JoinColumn(name = "id_przedmiotu"),
            inverseJoinColumns = @JoinColumn(name = "id_grupy_zajeciowej"))
    private Set<GrupaZajeciowa> grupyZajeciowe;

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

    public Przedmiot(String nazwa_przedmiotu) {
        this.nazwa_przedmiotu = nazwa_przedmiotu;
    }

    public Przedmiot() {
    }

    @Override
    public String toString() {
        return "Przedmiot{" +
                "id_przedmiotu=" + id_przedmiotu +
                ", nazwa_przedmiotu='" + nazwa_przedmiotu + '\'' +
                '}';
    }
}
