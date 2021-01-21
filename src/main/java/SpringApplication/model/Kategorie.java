package SpringApplication.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Kategorie {
    @Id
    private long kategorie_id;

    @ManyToMany
    Set<Gericht> Gerichte;

    private String name, beschreibung;

    private Kategorie(long id, String name, String beschreibung) {
        this.beschreibung = beschreibung;
        this.name = name;
        this.kategorie_id = id;
    }

    public Kategorie () {}
    public static Kategorie newKategorie(long id, String name, String beschreibung) {
        return new Kategorie(id, name, beschreibung);
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

    public void setName(String name) {
        this.name = name;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
}
