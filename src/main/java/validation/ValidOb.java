package validation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class ValidOb {

    @Id
    private int id;

    @NotNull
    private String notNull;

    @Positive
    private double positive;

    public ValidOb(int id, @NotNull String notNull, @Positive double positive) {
        this.id = id;
        this.notNull = notNull;
        this.positive = positive;
    }

    public ValidOb() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNotNull() {
        return notNull;
    }

    public void setNotNull(String notNull) {
        this.notNull = notNull;
    }

    public double getPositive() {
        return positive;
    }

    public void setPositive(double positive) {
        this.positive = positive;
    }
}
