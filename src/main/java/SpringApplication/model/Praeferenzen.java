package SpringApplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Praeferenzen {
    public long getPraef_id() {
        return praef_id;
    }

    public void setPraef_id(long praef_id) {
        this.praef_id = praef_id;
    }

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
