package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addStudent(String name, String passportNumber){
        return jdbcTemplate.update("Insert into Student (name, passport_Serial_Number) values (?,?)",name,passportNumber);
    }

    public List<Student> getAllStudents(){
        return jdbcTemplate.query("Select * from Student",
                (rs,rowNum) -> new Student(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("passport_Serial_Number")));
    }

}
