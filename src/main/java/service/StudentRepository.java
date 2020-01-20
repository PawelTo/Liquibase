package service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    long countByIdGreaterThan(int i);

    long countByNameLike(String s);

    long countByNameLikeAndPassportSerialNumberLike(String studentName_, String s);
}
