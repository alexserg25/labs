package local.haus.dao;

import java.util.List;
import local.haus.persist.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Integer> {

  public Unit findByName(String name);
  public List<Unit> findAllByName(String name);

}
