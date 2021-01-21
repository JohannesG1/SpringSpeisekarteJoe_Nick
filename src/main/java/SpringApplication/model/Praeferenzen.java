package SpringApplication.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Praeferenzen {
    @Id
    private Long id;

    private String beschreibung;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getBeschreibung() {
        return beschreibung;
    }
}
