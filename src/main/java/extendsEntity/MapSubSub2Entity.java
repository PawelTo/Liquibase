package extendsEntity;

import javax.persistence.Entity;

@Entity
public class MapSubSub2Entity extends MapSubEntity{

    private String mapSub2;

    public MapSubSub2Entity() {
    }

    public String getMapSub2() {
        return mapSub2;
    }

    public void setMapSub2(String mapSub2) {
        this.mapSub2 = mapSub2;
    }
}
