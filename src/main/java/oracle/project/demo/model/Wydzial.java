package oracle.project.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Wydzial {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wydzial_seq")
    @SequenceGenerator(name = "wydzial_seq", sequenceName = "wydzial_seq", initialValue = 1, allocationSize = 1)
    private Long id_wydzialu;
    private String nazwa_wydzialu;

    @OneToMany(mappedBy = "wydzial")
    private Set<Pracownik> pracownicy;

    public Long getId_wydzialu() {
        return id_wydzialu;
    }

    public void setId_wydzialu(Long id_wydzialu) {
        this.id_wydzialu = id_wydzialu;
    }

    public String getNazwa_wydzialu() {
        return nazwa_wydzialu;
    }

    public void setNazwa_wydzialu(String nazwa_wydzialu) {
        this.nazwa_wydzialu = nazwa_wydzialu;
    }

    public Wydzial(String nazwa_wydzialu) {
        this.nazwa_wydzialu = nazwa_wydzialu;
    }

    public Wydzial() {
    }

    @Override
    public String toString() {
        return "Wydzial{" +
                "id_wydzialu=" + id_wydzialu +
                ", nazwa_wydzialu='" + nazwa_wydzialu + '\'' +
                '}';
    }
}
