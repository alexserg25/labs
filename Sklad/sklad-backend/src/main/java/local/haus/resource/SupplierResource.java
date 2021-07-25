package local.haus.resource;

import java.util.List;
import local.haus.persist.
    Supplier;
import local.haus.persist.
    SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:63342")
@RequestMapping("/api/suppliers")
@RestController
public class SupplierResource {

  private final
  SupplierRepository repository;

  @Autowired
  public SupplierResource(
      SupplierRepository repository) {
    this.repository = repository;
  }

  @PostMapping(consumes = "application/json", produces = "application/json")
  public
  Supplier create(@RequestBody
      Supplier item) {
    return repository.save(item);
  }

  @DeleteMapping(path = "/{id}")
  public void delete(@PathVariable("id") int id) {
    repository.deleteById(id);
  }

  @GetMapping(path = "/all", produces = "application/json")
  public List<
      Supplier> findAll() {
    return repository.findAll();
  }

}
