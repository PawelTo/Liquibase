package app.extendsEntity;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class MapSubEntity {

    @Id
    private int id;
    private String name;

    /*public MapSubEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }*/

    public MapSubEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
