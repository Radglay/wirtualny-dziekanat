package oracle.project.demo.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Typ_zajec")
public class TypZajec {
    @Id
    private Long id_typu_zajec;
    private String nazwa_typu_zajec;

    public Long getId_typu_zajec() {
        return id_typu_zajec;
    }

    public void setId_typu_zajec(Long id_typu_zajec) {
        this.id_typu_zajec = id_typu_zajec;
    }

    public String getNazwa_typu_zajec() {
        return nazwa_typu_zajec;
    }

    public void setNazwa_typu_zajec(String nazwa_typu_zajec) {
        this.nazwa_typu_zajec = nazwa_typu_zajec;
    }

    public TypZajec(String nazwa_typu_zajec) {
        this.nazwa_typu_zajec = nazwa_typu_zajec;
    }

    @Override
    public String toString() {
        return "TypZajec{" +
                "id_typu_zajec=" + id_typu_zajec +
                ", nazwa_typu_zajec='" + nazwa_typu_zajec + '\'' +
                '}';
    }

    public TypZajec() {
    }
}
