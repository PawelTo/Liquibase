package service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtendetLvl2EntityRepository extends JpaRepository<ExtendetLvl2Entity,Long> {
}
