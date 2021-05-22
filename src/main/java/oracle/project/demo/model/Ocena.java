package oracle.project.demo.model;

import javax.persistence.*;

@Entity
public class Ocena {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ocena_seq")
    @SequenceGenerator(name = "ocena_seq", sequenceName = "ocena_seq", initialValue = 1, allocationSize = 1)
    private Long id_oceny;
    private String wartosc;
    private int waga_oceny;

    @ManyToOne
    @JoinColumn(name = "id_przedmiotu", nullable = false)
    private Przedmiot przedmiot;

    @ManyToOne
    @JoinColumn(name = "id_studenta", nullable = false)
    private Student student;

    public Long getId_oceny() {
        return id_oceny;
    }

    public void setId_oceny(Long id_oceny) {
        this.id_oceny = id_oceny;
    }

    public String getWartosc() {
        return wartosc;
    }

    public void setWartosc(String wartosc) {
        this.wartosc = wartosc;
    }

    public int getWaga_oceny() {
        return waga_oceny;
    }

    public void setWaga_oceny(int waga_oceny) {
        this.waga_oceny = waga_oceny;
    }

    public Przedmiot getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(Przedmiot przedmiot) {
        this.przedmiot = przedmiot;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Ocena(String wartosc, int waga_oceny , Przedmiot przedmiot, Student student) {
        this.wartosc = wartosc;
        this.waga_oceny = waga_oceny;
        this.przedmiot = przedmiot;
        this.student = student;
    }

    public Ocena() {
    }

    @Override
    public String toString() {
        return "Ocena{" +
                "id_oceny=" + id_oceny +
                ", wartosc='" + wartosc + '\'' +
                '}';
    }
}
