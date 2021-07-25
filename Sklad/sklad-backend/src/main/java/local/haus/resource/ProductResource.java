package local.haus.resource;

import java.util.List;
import local.haus.persist.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:63342")
@RequestMapping("/api/products")
@RestController
public class ProductResource {

  private final ProductRepository repository;

  @Autowired
  public ProductResource(ProductRepository repository) {
    this.repository = repository;
  }

  @PostMapping(consumes = "application/json", produces = "application/json")
  public Product create(@RequestBody Product item) {
    return repository.save(item);
  }

  @DeleteMapping(path = "/{id}")
  public void delete(@PathVariable("id") int id) {
    repository.deleteById(id);
  }

  @GetMapping(path = "/all", produces = "application/json")
  public List<Product> findAll() {
    return repository.findAll();
  }

}
