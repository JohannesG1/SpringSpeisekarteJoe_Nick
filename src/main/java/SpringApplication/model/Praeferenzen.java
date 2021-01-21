package SpringApplication.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Praeferenzen {
    @Id
    private long praef_id;

    @ManyToMany
    Set<Kategorie> preafcategory;

    @ManyToMany
    Set<Gericht> preafmeal;

    private String name, ernaerungsform;


    private Praeferenzen(long id, String name, String ernaerungsform){
        this.name = name;
        this.ernaerungsform = ernaerungsform;
        this.praef_id = id;
    }

    public Praeferenzen() {}
    public static Praeferenzen newPraef(long id, String name, String ernaerungsform) {
        return new Praeferenzen(id, name, ernaerungsform);
    }

    public void setId(Long id) {
        this.praef_id = id;
    }

    public long getId() {
        return praef_id;
    }

    public void setBeschreibung(String beschreibung) {
        this.name = name;
    }

    public String getBeschreibung() {
        return name;
    }

    public void setErnaerungsform(String ernaerungsform) {
        this.ernaerungsform = ernaerungsform;
    }

    public String getErnaerungsform(){
        return ernaerungsform;
    }
}
