package app.extendsEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseSingleRepo extends JpaRepository<BaseSingeTable, Long> {
}
