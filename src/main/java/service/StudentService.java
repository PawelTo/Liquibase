package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudentWithoutCache(){
        return studentRepository.findAll();
    }

    @Cacheable("students")
    public List<Student> getAllStudentWithCache(){
        return studentRepository.findAll();
    }

    public long countWithoutCache(){
        return studentRepository.countByNameLikeAndPassportSerialNumberLike("studentName_","passport%");
    }

    @Cacheable("count")
    public long countWithCache(){
        return studentRepository.countByNameLikeAndPassportSerialNumberLike("studentName_","passport%");
    }
}
