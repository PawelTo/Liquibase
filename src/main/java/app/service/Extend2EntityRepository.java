package app.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Extend2EntityRepository extends JpaRepository<Extend2Entity,Long> {
}
