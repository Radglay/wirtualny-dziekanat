package oracle.project.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    private Long ID_STUDENTA;
    private String imie_studenta;
    private String nazwisko_studenta;
    private String indeks_studenta;
    private Long id_grupy_zajeciowej;

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

    public Long getId_grupy_zajeciowej() {
        return id_grupy_zajeciowej;
    }

    public void setId_grupy_zajeciowej(Long id_grupy_zajeciowej) {
        this.id_grupy_zajeciowej = id_grupy_zajeciowej;
    }

    public void setId(Long ID_STUDENTA) {
        this.ID_STUDENTA = ID_STUDENTA;
    }

    public Long getId() {
        return ID_STUDENTA;
    }

    public Student(String imie_studenta, String nazwisko_studenta, String indeks_studenta, Long id_grupy_zajeciowej) {
        this.imie_studenta = imie_studenta;
        this.nazwisko_studenta = nazwisko_studenta;
        this.indeks_studenta = indeks_studenta;
        this.id_grupy_zajeciowej = id_grupy_zajeciowej;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID_STUDENTA=" + ID_STUDENTA +
                ", imie_studenta='" + imie_studenta + '\'' +
                ", nazwisko_studenta='" + nazwisko_studenta + '\'' +
                ", indeks_studenta='" + indeks_studenta + '\'' +
                ", id_grupy_zajeciowej=" + id_grupy_zajeciowej +
                '}';
    }
}
