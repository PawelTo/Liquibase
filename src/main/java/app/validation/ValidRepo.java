package app.validation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValidRepo extends JpaRepository<ValidOb,Long> {

    List<ValidOb> findAllByOrderById();
}
