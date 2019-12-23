package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.Student;
import service.StudentService;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/start")
    public String start(){
        return "start";
    }

    @GetMapping("/getStudents")
    public List<Student> getAllStudents(){
        return studentService.getAllStudent();
    }
}
