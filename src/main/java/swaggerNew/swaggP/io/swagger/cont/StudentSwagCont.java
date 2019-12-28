package swaggerNew.swaggP.io.swagger.cont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.Student;
import swaggerNew.swaggP.io.swagger.model.StudentSwag;

@RestController
public class StudentSwagCont {

    @Autowired
    private StudentSwag StudentSwag;

    @GetMapping("/dummy")
    public StudentSwag dummy(){
        StudentSwag.setName("name");
        return StudentSwag;
    }

    @GetMapping("/dummy2")
    public Student dummy2(){
        Student student = new Student();
        student.setName("imie");
        return student;
    }
}