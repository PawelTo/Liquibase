package extendsEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapSubRepo extends JpaRepository<MapSubEntity, Long> {
}
