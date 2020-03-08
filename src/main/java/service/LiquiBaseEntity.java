package service;

public class LiquiBaseEntity {
    private String str;
    private int integerColumn;

    public LiquiBaseEntity(String str, int integerColumn) {
        this.str = str;
        this.integerColumn = integerColumn;
    }

    public LiquiBaseEntity() {
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getIntegerColumn() {
        return integerColumn;
    }

    public void setIntegerColumn(int integerColumn) {
        this.integerColumn = integerColumn;
    }
}
