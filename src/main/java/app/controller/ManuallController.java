package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import app.service.Student;
import app.service.StudentDAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@RestController
public class ManuallController {

    @Autowired
    private StudentDAO studentDAO;

    @GetMapping("/getStudentAdd")
    public Student getStudentAdd(){
        Student student = new Student();
        student.setName("z obiektu");
        student.setPassportSerialNumber(String.valueOf(studentDAO.addStudent("imie z obiektu","paszport z obiektu")));
        return student;
    }

    @GetMapping("/getAllStudentDAO")
    public List<Student> getAllStudentDAO(){
        return studentDAO.getAllStudents();
    }

    @GetMapping("/getStudentEntity")
    public ResponseEntity getStudentEntity(){
        Student student = new Student();
        student.setName("z entity");
        return new ResponseEntity(student, HttpStatus.OK);
    }

    @GetMapping("/getStudentList")
    public ArrayList<Student> getStudentList(){
        Student student = new Student();
        student.setName("imie do listy 1");
        Student student2 = new Student();
        student2.setName("imie do listy 2");
        ArrayList<Student> lista = new ArrayList<>(Arrays.asList(student,student2));
        return lista;
    }

    @GetMapping("/getStudentListEntity")
    public ResponseEntity getStudentListEntity(){
        Student student = new Student();
        student.setName("imie do listy 1");
        Student student2 = new Student();
        student2.setName("imie do listy 2");
        ArrayList<Student> lista = new ArrayList<>(Arrays.asList(student,student2));
        return new ResponseEntity(lista,HttpStatus.OK);
    }

    @GetMapping("/getStudentSet")
    public HashSet getStudentSet(){
        Student student = new Student();
        student.setName("imie do listy 1");
        Student student2 = new Student();
        student2.setName("imie do listy 2");
        HashSet hashSet = new HashSet(Arrays.asList(student,student2));
        return hashSet;
    }
}
