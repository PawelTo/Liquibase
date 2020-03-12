package service;

import javax.persistence.Entity;

@Entity
public class ExtendentEntity extends BasicEntity{
    private String onlyExtendentColumn;

    public ExtendentEntity(String stringColumn, int intColumn, Integer integerColumn, long longColumn, double doubleColumn, boolean booleanColumn, String onlyExtendentColumn) {
        super(stringColumn, intColumn, integerColumn, longColumn, doubleColumn, booleanColumn);
        this.onlyExtendentColumn = onlyExtendentColumn;
    }

    public ExtendentEntity() {}

    public String getOnlyExtendentColumn() {
        return onlyExtendentColumn;
    }

    public void setOnlyExtendentColumn(String onlyExtendentColumn) {
        this.onlyExtendentColumn = onlyExtendentColumn;
    }
}
