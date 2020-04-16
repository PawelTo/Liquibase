package app.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testAddStudent(){
        // given
        List<Student> studentList = createTestingStudent();
        Student student1 = studentList.get(0);
        Student student2 = studentList.get(1);

        testEntityManager.persist(student1);
        testEntityManager.flush();

        studentRepository.save(student2);

        Optional<Student> finded2 = studentRepository.findById(2);
        assertEquals(student2.getName(),finded2.get().getName());
        assertEquals(student2.getPassportSerialNumber(),finded2.get().getPassportSerialNumber());
        assertEquals(2,studentRepository.countByIdGreaterThan(1));
    }

    @Test
    public void removeStudent(){
        createTestingStudent().stream().forEach(student -> studentRepository.save(student));

        //check size after saving new objects
        assertEquals(6,studentRepository.findAll().size());

        studentRepository.deleteById(3);
        //check size after remove object
        assertEquals(5,studentRepository.findAll().size());
    }

    @Test
    public void removeStudentDividedIdBy3(){
        createTestingStudent().stream().forEach(student -> studentRepository.save(student));

        //check size after saving new objects
        assertEquals(6,studentRepository.findAll().size());

        studentRepository.deleteByIdDevidedBy3();
        //check size after remove object
        assertEquals(5,studentRepository.findAll().size());
    }

    private List<Student> createTestingStudent(){
        Student student = new Student("test1","test1");
        student.setName("test1_name1");
        student.setPassportSerialNumber("test1_passport_num1");
        Student student2 = new Student("test1_name2","test1_Passport_num2");
        Student student3 = new Student("test1_name3","test1_Passport_num3");
        return Arrays.asList(student,student2,student3);
    }
}