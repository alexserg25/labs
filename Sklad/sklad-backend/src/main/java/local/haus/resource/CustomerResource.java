package local.haus.resource;

import java.util.List;
import local.haus.persist.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:63342")
@RequestMapping("/api/customers")
@RestController
public class CustomerResource {

  private final CustomerRepository repository;

  @Autowired
  public CustomerResource(CustomerRepository repository) {
    this.repository = repository;
  }

  @PostMapping(consumes = "application/json", produces = "application/json")
  public Customer create(@RequestBody Customer item) {
    return repository.save(item);
  }

  @DeleteMapping(path = "/{id}")
  public void delete(@PathVariable("id") int id) {
    repository.deleteById(id);
  }

  @GetMapping(path = "/all", produces = "application/json")
  public List<Customer> findAll() {
    return repository.findAll();
  }

}
