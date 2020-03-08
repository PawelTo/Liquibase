package service;

import javax.persistence.Entity;

@Entity
public class ExtendentEntity extends BasicEntity{
    private String onlyExtendentColumn;

    public ExtendentEntity(String stringColumn, int intColumn, Integer integerColumn, long longColumn, double doubleColumn, boolean booleanColumn) {
        super(stringColumn, intColumn, integerColumn, longColumn, doubleColumn, booleanColumn);
    }
}
