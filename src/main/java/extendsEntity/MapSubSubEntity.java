package extendsEntity;

import javax.persistence.Entity;

@Entity
public class MapSubSubEntity extends MapSubEntity {

    private String subEntity;

    public MapSubSubEntity(int id, String name, String subEntity) {
        super(id, name);
        this.subEntity = subEntity;
    }
}
