package service;

import javax.persistence.Entity;

@Entity
public class Extend2Entity extends BasicEntity{

    private String extend2EntityOnly;

    /*public Extend2Entity(String stringColumn, int intColumn, Integer integerColumn, long longColumn, double doubleColumn, boolean booleanColumn, String extend2EntityOnly) {
        super(stringColumn, intColumn, integerColumn, longColumn, doubleColumn, booleanColumn);
        this.extend2EntityOnly = extend2EntityOnly;
    }*/

    public Extend2Entity() {}

    public String getExtend2EntityOnly() {
        return extend2EntityOnly;
    }

    public void setExtend2EntityOnly(String extend2EntityOnly) {
        this.extend2EntityOnly = extend2EntityOnly;
    }
}
