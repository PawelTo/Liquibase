package app.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@Import(StudentDAO.class)
class StudentDAOTest {

    private static final String PASSPORT_NUMBER = "passportName";
    private final String name = "name";

    @Autowired
    private StudentDAO studentDAO;

    @Test
    @Sql(statements = "truncate table Student")
    void test() {
        studentDAO.addStudent(name, PASSPORT_NUMBER);
        List<Student> allStudents = studentDAO.getAllStudents();
        assertThat(allStudents.size(),is(1));
        assertThat(allStudents.get(0).getName(),is(name));
        assertEquals(PASSPORT_NUMBER, allStudents.get(0).getPassportSerialNumber());
        assertThat(allStudents.get(0).getName()).isEqualTo(name);
    }
}