package oracle.project.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dziedzina {
    @Id
    private Long id_dziedziny;

    private String nazwa_dziedziny;

    public Long getId_dziedziny() {
        return id_dziedziny;
    }

    public void setId_dziedziny(Long id_dziedziny) {
        this.id_dziedziny = id_dziedziny;
    }

    public String getNazwa_dziedziny() {
        return nazwa_dziedziny;
    }

    public void setNazwa_dziedziny(String nazwa_dziedziny) {
        this.nazwa_dziedziny = nazwa_dziedziny;
    }

    public Dziedzina(String nazwa_dziedziny) {
        this.nazwa_dziedziny = nazwa_dziedziny;
    }

    public Dziedzina() {
    }

    @Override
    public String toString() {
        return "Dziedzina{" +
                "id_dziedziny=" + id_dziedziny +
                ", nazwa_dziedziny='" + nazwa_dziedziny + '\'' +
                '}';
    }

}
