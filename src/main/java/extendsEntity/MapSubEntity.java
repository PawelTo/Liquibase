package extendsEntity;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class MapSubEntity {

    @Id
    private int id;
    private String name;

    public MapSubEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
