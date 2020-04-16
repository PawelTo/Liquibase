package app.extendsEntity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class ExTabPerEnt extends BaseTabPerEnt{

    private String exTabPerEnt;

    public String getExTabPerEnt() {
        return exTabPerEnt;
    }

    public void setExTabPerEnt(String exTabPerEnt) {
        this.exTabPerEnt = exTabPerEnt;
    }
}
