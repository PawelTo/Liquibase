package app.extendsEntity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("extJoinedTable_value")
public class ExtJoinedTable extends BaseJoinedTable{

    private String extJoinedTable;

    public String getExtJoinedTable() {
        return extJoinedTable;
    }

    public void setExtJoinedTable(String extJoinedTable) {
        this.extJoinedTable = extJoinedTable;
    }
}
