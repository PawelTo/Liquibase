package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Caching(cacheable = {
            @Cacheable("count"),
            @Cacheable("freshCount")
    })
    public long countWithCache(){
        return studentRepository.countByNameLikeAndPassportSerialNumberLike("studentName_","passport%");
    }

    @CacheEvict(value="count", key = "#cacheKey")
    public void evictCacheValue(String cacheKey){}

    @Transactional
    @CachePut("freshCount")
    public long refreshCountPut(){
        Student s = new Student(2, "insertByCachePut", "CachPutPassNo");
        Student s2 = new Student();
        s2.setName("s2Name,");
        s2.setPassportSerialNumber("s2PassportName");
        studentRepository.deleteByIdDevidedBy3();
        return studentRepository.countByNameLikeAndPassportSerialNumberLike("studentName_","passport%");
    }

    @Cacheable("count")
    public long getCountValue(){
        return studentRepository.countByNameLikeAndPassportSerialNumberLike("studentName_","passport%");
    }

    @Cacheable("freshCount")
    public long getFreshValue(){
        return studentRepository.countByNameLikeAndPassportSerialNumberLike("studentName_","passport%");
    }
}
