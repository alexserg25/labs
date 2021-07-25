package local.haus.resource;

import java.util.List;
import local.haus.persist.Sale;
import local.haus.persist.SaleItem;
import local.haus.persist.SaleItemRepository;
import local.haus.persist.SaleRepository;
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
@RequestMapping("/api/sale_items")
@RestController
public class SaleItemResource {

  private final SaleItemRepository repository;

  @Autowired
  public SaleItemResource(SaleItemRepository repository) {
    this.repository = repository;
  }

  @PostMapping(consumes = "application/json", produces = "application/json")
  public SaleItem create(@RequestBody SaleItem item) {
    return repository.save(item);
  }

  @DeleteMapping(path = "/{id}")
  public void delete(@PathVariable("id") int id) {
    repository.deleteById(id);
  }

  @GetMapping(path = "/all", produces = "application/json")
  public List<SaleItem> findAll() {
    return repository.findAll();
  }

}
