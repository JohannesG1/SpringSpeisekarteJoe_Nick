package SpringApplication.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Praeferenzen {
    @Id
    private long praef_id;

    public Praeferenzen(long praef_id, String eingaben) {
        this.praef_id = praef_id;
        this.eingaben = eingaben;
    }

    public Praeferenzen() {
    }

    public String getEingaben() {
        return eingaben;
    }

    public void setEingaben(String eingaben) {
        this.eingaben += eingaben + ",";
    }

    String eingaben = "";
}
