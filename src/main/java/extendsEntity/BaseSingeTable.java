package extendsEntity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dis_column", discriminatorType = DiscriminatorType.STRING)
public class BaseSingeTable {

    @Id
    private int id;
    private String name;

    public BaseSingeTable() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
