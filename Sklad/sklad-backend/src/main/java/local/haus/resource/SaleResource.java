package local.haus.resource;

import java.util.List;
import local.haus.persist.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:63342")
@RequestMapping("/api/sales")
@RestController
public class SaleResource {

  private final SaleRepository repository;

  @Autowired
  public SaleResource(SaleRepository repository) {
    this.repository = repository;
  }

  @PostMapping(consumes = "application/json", produces = "application/json")
  public Sale create(@RequestBody Sale item) {
    return repository.save(item);
  }

  @DeleteMapping(path = "/{id}")
  public void delete(@PathVariable("id") int id) {
    repository.deleteById(id);
  }

  @GetMapping(path = "/all", produces = "application/json")
  public List<Sale> findAll() {
    return repository.findAll();
  }

}
