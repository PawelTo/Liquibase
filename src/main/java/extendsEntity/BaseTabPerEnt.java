package extendsEntity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "dis_column", discriminatorType = DiscriminatorType.INTEGER)
public class BaseTabPerEnt {

    @Id
    private int id;
    private String name;

    public BaseTabPerEnt() {
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
