package service;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BasicEntity {

    @Id
    private String stringColumn;
    private int intColumn;
    private Integer IntegerColumn;
    private long longColumn;
    private double doubleColumn;
    private boolean booleanColumn;

    public BasicEntity(String stringColumn, int intColumn, Integer integerColumn, long longColumn, double doubleColumn, boolean booleanColumn) {
        this.stringColumn = stringColumn;
        this.intColumn = intColumn;
        IntegerColumn = integerColumn;
        this.longColumn = longColumn;
        this.doubleColumn = doubleColumn;
        this.booleanColumn = booleanColumn;
    }

    public String getStringColumn() {
        return stringColumn;
    }

    public void setStringColumn(String stringColumn) {
        this.stringColumn = stringColumn;
    }

    public int getIntColumn() {
        return intColumn;
    }

    public void setIntColumn(int intColumn) {
        this.intColumn = intColumn;
    }

    public Integer getIntegerColumn() {
        return IntegerColumn;
    }

    public void setIntegerColumn(Integer integerColumn) {
        IntegerColumn = integerColumn;
    }

    public long getLongColumn() {
        return longColumn;
    }

    public void setLongColumn(long longColumn) {
        this.longColumn = longColumn;
    }

    public double getDoubleColumn() {
        return doubleColumn;
    }

    public void setDoubleColumn(double doubleColumn) {
        this.doubleColumn = doubleColumn;
    }

    public boolean isBooleanColumn() {
        return booleanColumn;
    }

    public void setBooleanColumn(boolean booleanColumn) {
        this.booleanColumn = booleanColumn;
    }
}
