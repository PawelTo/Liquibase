package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.Student;
import service.StudentDAO;
import service.StudentService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentDAO studentDAO;

    @GetMapping("/start")
    public String start(){
        return "start";
    }

    @GetMapping("/getStudents")
    public List<Student> getAllStudents(){
        return studentService.getAllStudent();
    }

    @GetMapping("/insert")
    public void insertStudents(){
        ArrayList returnedList = new ArrayList();
        for (int i=0 ;i<20;i++){
            returnedList.add(studentDAO.addStudent("studentName"+i,"passport"+i*2));
        }
        return;
    }
}
