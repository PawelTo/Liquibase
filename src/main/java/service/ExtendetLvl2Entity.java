package service;

import javax.persistence.Entity;

@Entity
public class ExtendetLvl2Entity extends ExtendentEntity{

    private String onlyExtendetLvl2;

    public ExtendetLvl2Entity() {
    }

    public String getOnlyExtendetLvl2() {
        return onlyExtendetLvl2;
    }

    public void setOnlyExtendetLvl2(String onlyExtendetLvl2) {
        this.onlyExtendetLvl2 = onlyExtendetLvl2;
    }
}
