package app.service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {

    @GeneratedValue
    @Id
    private int id;
    private String name;
    private String passportSerialNumber;

    public Student(int id, String name, String passportSerialNumber) {
        this.id = id;
        this.name = name;
        this.passportSerialNumber = passportSerialNumber;
    }

    public Student() {
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

    public String getPassportSerialNumber() {
        return passportSerialNumber;
    }

    public void setPassportSerialNumber(String passportSerialNumber) {
        this.passportSerialNumber = passportSerialNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passportSerialNumber='" + passportSerialNumber + '\'' +
                '}';
    }
}
