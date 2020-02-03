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
        long start = System.currentTimeMillis();
        List<Student> allStudentWithoutCache = studentService.getAllStudentWithoutCache();
        System.out.println("get from DB time:" + (System.currentTimeMillis()-start));
        System.out.println("List count: "+allStudentWithoutCache.size());
        return allStudentWithoutCache;
    }

    @GetMapping("/getCachedStudents")
    public List<Student> getAllStudentsCache(){
        long start = System.currentTimeMillis();
        List<Student> allStudentWithCache = studentService.getAllStudentWithCache();
        System.out.println("get from cache time:" + (System.currentTimeMillis()-start));
        System.out.println("List count: "+allStudentWithCache.size());
        return allStudentWithCache;
    }

    @GetMapping("/insert")
    public ArrayList insertStudents(){
        ArrayList returnedList = new ArrayList();
        for (int i=0 ;i<2000;i++){
            returnedList.add(studentDAO.addStudent("studentName"+i,"passport"+i*2));
        }
        return returnedList;
    }

    @GetMapping("/countCache")
    public long countWithCache(){
        long start = System.currentTimeMillis();
        long studenNumber = studentService.countWithCache();
        System.out.println("get from cache time:" + (System.currentTimeMillis()-start)+" number: "+studenNumber);
        return studenNumber;
    }

    @GetMapping("/countWithoutCache")
    public long countWithoutCache(){
        long start = System.currentTimeMillis();
        long studenNumber = studentService.countWithoutCache();
        System.out.println("get from DB time:" + (System.currentTimeMillis()-start)+" number: "+studenNumber);
        return studenNumber;
    }

    @GetMapping("/clearCache")
    public void clearCache(){
        studentService.evictCacheValue("1");
        System.out.println("cache cleared");
    }

    @GetMapping("/freshCache")
    public long freshCachePut(){
        return studentService.refreshCountPut();
    }

    @GetMapping("/cacheValue")
    public void printCacheNumbers(){
        System.out.println("Wartość count: "+studentService.getCountValue());
        System.out.println("wartość fresh: "+studentService.getFreshValue());
    }
}
