package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addStudent(){
        return jdbcTemplate.update("Insert into Student (name, passport_Number) values (?,?)","imie","paszport");
    }
}
