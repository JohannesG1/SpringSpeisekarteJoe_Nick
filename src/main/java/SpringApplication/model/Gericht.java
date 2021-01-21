package SpringApplication.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Gericht {
    @Id
    private long gericht_id;

    @ManyToMany
    Set<Kategorie> zuordnungenKat;
    @ManyToMany
    Set<Praeferenzen> zuordnungPrae;

    private String name, beschreibung;
    private double preis;

    private Gericht(long id, String name, String beschreibung, double preis) {
        this.beschreibung = beschreibung;
        this.name = name;
        this.gericht_id = id;
        this.preis = preis;
    }

    public Gericht () {}
    public Gericht newGericht(long id, String name, String beschreibung, double preis) {
        return new Gericht(id, name, beschreibung, preis);
    }

    public String toString() {
        return this.name + ": " + this.beschreibung;
    }

    public String getName() {
        return this.name;
    }

    public String getBeschreibung() {
        return this.beschreibung;
    }
    public double getPreis() {
        return this.preis;
    }
    public long getGericht_id () {
        return this.gericht_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

}
