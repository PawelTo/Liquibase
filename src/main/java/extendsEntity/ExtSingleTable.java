package extendsEntity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("extSingleTable_value")
public class ExtSingleTable extends BaseSingeTable{

    private String namesub;

    public String getNamesub() {
        return namesub;
    }

    public void setNamesub(String namesub) {
        this.namesub = namesub;
    }
}
