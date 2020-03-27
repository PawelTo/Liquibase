package validation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidRepo extends JpaRepository<ValidOb,Long> {
}
