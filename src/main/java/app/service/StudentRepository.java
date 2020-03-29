package app.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    long countByIdGreaterThan(int i);

    long countByNameLike(String s);

    long countByNameLikeAndPassportSerialNumberLike(String studentName_, String s);

    @Modifying
    @Query(value = "delete from Student s where MOD(s.id,3) = 0", nativeQuery = true)
    void deleteByIdDevidedBy3();
}
