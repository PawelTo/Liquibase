package extendsEntity;

import javax.persistence.Entity;

@Entity
public class MapSubSubEntity extends MapSubEntity {

    private String subEntity;

    public MapSubSubEntity(){}

    /*public MapSubSubEntity(int id, String name, String subEntity) {
        super(id, name);
        this.subEntity = subEntity;
    }*/

    public void setSubEntity(String subEntity) {
        this.subEntity = subEntity;
    }
}
