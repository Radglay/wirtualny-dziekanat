package oracle.project.demo.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class GrupaZajeciowa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_grupy_zajeciowej;
    private String nazwa_grupy_zajeciowej;
    private Date czas_rozpoczecia;
    private Date czas_zakonczenia;

    private Long fk_id_typu_zajec;
    private Long fk_id_przedmiotu;

    @ManyToMany(mappedBy = "grupyZajeciowe")
    Set<Student> studenci;

    @ManyToMany(mappedBy = "grupyZajeciowe")
    Set<Pracownik> pracownicy;


    public Long getFk_id_typu_zajec() {
        return fk_id_typu_zajec;
    }

    public void setFk_id_typu_zajec(Long fk_id_typu_zajec) {
        this.fk_id_typu_zajec = fk_id_typu_zajec;
    }


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

    public void setFk_id_przedmiotu(Long id_przedmiotu) {
        this.fk_id_przedmiotu = id_przedmiotu;
    }

    public Long getId_grupy_zajeciowej() {
        return id_grupy_zajeciowej;
    }

    public String getNazwa_grupy_zajeciowej() {
        return nazwa_grupy_zajeciowej;
    }

    public Long getFk_id_przedmiotu() {
        return fk_id_przedmiotu;
    }



    public GrupaZajeciowa() {
    }

    public GrupaZajeciowa(String nazwa_grupy_zajeciowej, Date czas_rozpoczecia, Date czas_zakonczenia, Long fk_id_typu_zajec, Long fk_id_przedmiotu) {
        this.nazwa_grupy_zajeciowej = nazwa_grupy_zajeciowej;
        this.czas_rozpoczecia = czas_rozpoczecia;
        this.czas_zakonczenia = czas_zakonczenia;
        this.fk_id_typu_zajec = fk_id_typu_zajec;
        this.fk_id_przedmiotu = fk_id_przedmiotu;
    }

    @Override
    public String toString() {
        return "GrupaZajeciowa{" +
                "id_grupy_zajeciowej=" + id_grupy_zajeciowej +
                ", nazwa_grupy_zajeciowej='" + nazwa_grupy_zajeciowej + '\'' +
                ", id_przedmiotu=" + fk_id_przedmiotu +
                '}';
    }
}
