package app.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicEntityRepository extends JpaRepository<BasicEntity, Long> {
}
