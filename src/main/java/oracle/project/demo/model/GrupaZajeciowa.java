package oracle.project.demo.model;



import javax.persistence.*;
import java.util.Set;

@Entity
public class GrupaZajeciowa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grupa_zajeciowa_seq")
    @SequenceGenerator(name = "grupa_zajeciowa_seq", sequenceName = "grupa_zajeciowa_seq", initialValue = 1, allocationSize = 1)
    private Long id_grupy_zajeciowej;
    private String nazwa_grupy_zajeciowej;


    @ManyToMany(mappedBy = "grupyZajeciowe")
    private Set<Student> studenci;

    @ManyToMany(mappedBy = "grupyZajeciowe")
    private Set<Pracownik> pracownicy;

    @ManyToMany(mappedBy = "grupyZajeciowe")
    private Set<Przedmiot> przedmioty;

    public Long getId_grupy_zajeciowej() {
        return id_grupy_zajeciowej;
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

    public GrupaZajeciowa(String nazwa_grupy_zajeciowej) {
        this.nazwa_grupy_zajeciowej = nazwa_grupy_zajeciowej;
    }

    @Override
    public String toString() {
        return "GrupaZajeciowa{" +
                "id_grupy_zajeciowej=" + id_grupy_zajeciowej +
                ", nazwa_grupy_zajeciowej='" + nazwa_grupy_zajeciowej + '\'' +
                '}';
    }

    //todo
    /*
    terminarz z zajeciami
     */
}
