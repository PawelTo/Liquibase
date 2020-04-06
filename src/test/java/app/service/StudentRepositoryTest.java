package app.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

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
        Student student = new Student(2,"name_test_1","passport_test1");
        //testEntityManager.persist(student);
        assertEquals(1,studentRepository.countByIdGreaterThan(1));
    }
}