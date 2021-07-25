package local.haus.service;

import java.util.List;
import local.haus.persist.Unit;

public interface UnitService {

  public List<Unit> getAll();

  public void save(Unit unit);

  public Unit getById(int id);

  public void delete(int id);

  public List<Unit> findAllByName(String name);

}
