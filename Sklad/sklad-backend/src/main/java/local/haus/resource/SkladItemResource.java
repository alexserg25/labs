package local.haus.resource;

import local.haus.persist.SkladItem;
import local.haus.persist.SkladItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:63342")
@RequestMapping("/api/item")
@RestController
public class SkladItemResource {

  private final SkladItemRepository repository;

  @Autowired
  public SkladItemResource(SkladItemRepository repository) {
    this.repository = repository;
  }

  @PostMapping(consumes = "application/json", produces = "application/json")
  public SkladItem create(@RequestBody SkladItem item) {
    return repository.save(item);
  }

  @DeleteMapping(path = "/{id}")
  public void delete(@PathVariable("id") long id) {
    repository.deleteById(id);
  }

  @GetMapping(path = "/all", produces = "application/json")
  public List<SkladItem> findAll() {
    return repository.findAll();
  }


}
