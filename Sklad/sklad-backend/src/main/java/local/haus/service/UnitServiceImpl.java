package local.haus.service;

import java.util.List;
import java.util.Optional;
import local.haus.persist.Unit;
import local.haus.dao.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitServiceImpl implements UnitService {

  @Autowired
  private UnitRepository unitRepository;

  @Override
  public List<Unit> getAll() {
    return unitRepository.findAll();
  }

  @Override
  public void save(Unit unit) {
    unitRepository.save(unit);
  }

  @Override
  public Unit getById(int id) {
    Unit unit = null;
    Optional<Unit> optional = unitRepository.findById(id);

    if (optional.isPresent()) {
      unit = optional.get();
    }
    return unit;
  }

  @Override
  public void delete(int id) {
    unitRepository.deleteById(id);
  }

  @Override
  public List<Unit> findAllByName(String name) {
    List<Unit> units = unitRepository.findAllByName(name);
    return units;
  }
}
