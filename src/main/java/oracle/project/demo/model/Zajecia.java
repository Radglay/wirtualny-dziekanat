package oracle.project.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Zajecia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_zajec;
    private Long id_pracownika;
    private Long id_grupy_zajeciowej;
    private Date czas_rozpoczecia;
    private Date czas_zakonczenia;
    private Long id_typu_zajec;

    public Long getId_zajec() {
        return id_zajec;
    }

    public void setId_zajec(Long id_zajec) {
        this.id_zajec = id_zajec;
    }

    public Long getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(Long id_pracownika) {
        this.id_pracownika = id_pracownika;
    }

    public Long getId_grupy_zajeciowej() {
        return id_grupy_zajeciowej;
    }

    public void setId_grupy_zajeciowej(Long id_grupy_zajeciowej) {
        this.id_grupy_zajeciowej = id_grupy_zajeciowej;
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

    public Long getId_typu_zajec() {
        return id_typu_zajec;
    }

    public void setId_typu_zajec(Long id_typu_zajec) {
        this.id_typu_zajec = id_typu_zajec;
    }

    public Zajecia(Long id_pracownika, Long id_grupy_zajeciowej, Date czas_rozpoczecia, Date czas_zakonczenia, Long id_typu_zajec) {
        this.id_pracownika = id_pracownika;
        this.id_grupy_zajeciowej = id_grupy_zajeciowej;
        this.czas_rozpoczecia = czas_rozpoczecia;
        this.czas_zakonczenia = czas_zakonczenia;
        this.id_typu_zajec = id_typu_zajec;
    }

    public Zajecia() {
    }

    @Override
    public String toString() {
        return "Zajecia{" +
                "id_zajec=" + id_zajec +
                ", id_pracownika=" + id_pracownika +
                ", id_grupy_zajeciowej=" + id_grupy_zajeciowej +
                ", czas_rozpoczecia=" + czas_rozpoczecia +
                ", czas_zakonczenia=" + czas_zakonczenia +
                ", id_typu_zajec=" + id_typu_zajec +
                '}';
    }
}
