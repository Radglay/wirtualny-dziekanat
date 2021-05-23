package oracle.project.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class GrupaZajeciowa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grupa_zajeciowa_seq")
    @SequenceGenerator(name = "grupa_zajeciowa_seq", sequenceName = "grupa_zajeciowa_seq", initialValue = 1, allocationSize = 1)
    private Long id_grupy_zajeciowej;
    private String nazwa_grupy_zajeciowej;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date czas_rozpoczecia;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date czas_zakonczenia;

    @ManyToMany(mappedBy = "grupyZajeciowe")
    Set<Student> studenci;

    @ManyToMany(mappedBy = "grupyZajeciowe")
    Set<Pracownik> pracownicy;

    public Date getCzas_rozpoczecia() {
        return czas_rozpoczecia;
    }

    public void setCzas_rozpoczecia(Date czas_rozpoczecia) {
        this.czas_rozpoczecia = czas_rozpoczecia;
    }

    public Date getCzas_zakonczenia() {
        return czas_zakonczenia;
    }

    public void setCzas_zakonczenia(Date czas_zakonczenia) {
        this.czas_zakonczenia = czas_zakonczenia;
    }

    public void setId_grupy_zajeciowej(Long id_grupy_zajeciowej) {
        this.id_grupy_zajeciowej = id_grupy_zajeciowej;
    }

    public void setNazwa_grupy_zajeciowej(String nazwa_grupy_zajeciowej) {
        this.nazwa_grupy_zajeciowej = nazwa_grupy_zajeciowej;
    }

    public String getNazwa_grupy_zajeciowej() {
        return nazwa_grupy_zajeciowej;
    }

    public GrupaZajeciowa() {
    }

    public GrupaZajeciowa(String nazwa_grupy_zajeciowej, Date czas_rozpoczecia, Date czas_zakonczenia) {
        this.nazwa_grupy_zajeciowej = nazwa_grupy_zajeciowej;
        this.czas_rozpoczecia = czas_rozpoczecia;
        this.czas_zakonczenia = czas_zakonczenia;
    }

    @Override
    public String toString() {
        return "GrupaZajeciowa{" +
                "id_grupy_zajeciowej=" + id_grupy_zajeciowej +
                ", nazwa_grupy_zajeciowej='" + nazwa_grupy_zajeciowej + '\'' +
                ", czas_rozpoczecia=" + czas_rozpoczecia +
                ", czas_zakonczenia=" + czas_zakonczenia +
                '}';
    }

    //todo
    /*
    terminarz z zajeciami
     */
}
