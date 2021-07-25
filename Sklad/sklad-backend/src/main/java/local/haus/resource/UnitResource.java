package local.haus.resource;

import java.util.List;
import local.haus.persist.Unit;
import local.haus.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin("http://localhost:63342")
@RequestMapping("/api/units")
@RestController
public class UnitResource {

  @Autowired
  private UnitService unitService;

  @GetMapping()
  public List<Unit> getAllUnits() {
    List<Unit> units = unitService.getAll();
    return units;
  }

  @GetMapping("/{id}")
  public Unit getUnit(@PathVariable int id) {
    Unit unit = unitService.getById(id);
    return unit;
  }

  @GetMapping("/name/{name}")
  public List<Unit> findAllByName(@PathVariable String name) {
                              List<Unit> units = unitService.findAllByName(name);
    return units;
  }

  @DeleteMapping(path = "/{id}")
  public void delete(@PathVariable("id") int id) {
    unitService.delete(id);
  }

  @PostMapping()
  public Unit create(@RequestBody Unit unit) {
    unitService.save(unit);
    return unit;
  }

  public Unit update(@RequestBody Unit unit) {
    unitService.save(unit);
    return unit;
  }


//  private final UnitRepository repository;
//
//  @Autowired
//  public UnitResource(UnitRepository repository) {
//    this.repository = repository;
//  }
//
//  @PostMapping(consumes = "application/json", produces = "application/json")
//  public Unit create(@RequestBody Unit item) {
//    return repository.save(item);
//  }
//
//  @DeleteMapping(path = "/{id}")
//  public void delete(@PathVariable("id") int id) {
//    repository.deleteById(id);
//  }
//
//  @GetMapping(path = "/all", produces = "application/json")
//  public List<Unit> findAll() {
//    return repository.findAll();
//  }


}
