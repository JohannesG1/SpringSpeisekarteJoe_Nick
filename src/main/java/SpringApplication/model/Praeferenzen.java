package SpringApplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Praeferenzen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long praef_id;

    public Praeferenzen(String eingaben) {
        this.eingaben = eingaben;
    }

    public Praeferenzen() {
    }

    public String getEingaben() {
        return eingaben;
    }

    public void setEingaben(String eingaben) {
        this.eingaben = eingaben;
    }

    String eingaben = "";
}
