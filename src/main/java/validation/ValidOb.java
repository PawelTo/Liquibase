package validation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class ValidOb {

    @Id
    private int id;

    @NotNull
    private String notNull;

    @Positive(groups = FirstStepValidation.class)
    private double positive;

    @Max(value = 5, groups = SecondStepValidation.class)
    @Min(value = -5, groups = {FirstStepValidation.class, SecondStepValidation.class})
    private int range;

    public ValidOb(int id, @NotNull String notNull, @Positive(groups = FirstStepValidation.class) double positive,
                   @Max(value = 5, groups = SecondStepValidation.class) @Min(value = -5, groups = {FirstStepValidation.class, SecondStepValidation.class}) int range) {
        this.id = id;
        this.notNull = notNull;
        this.positive = positive;
        this.range = range;
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

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    @Override
    public String toString() {
        return "ValidOb{" +
                "id=" + id +
                ", notNull='" + notNull + '\'' +
                ", positive=" + positive +
                ", range=" + range +
                '}';
    }
}
