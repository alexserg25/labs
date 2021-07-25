package local.haus.persist;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "units")
public class Unit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id"
      , nullable = false)
  private int id;

  @Column(name = "name"
      , nullable = false)
  private String name;

//  @OneToMany(mappedBy = "unit"
//      , cascade = {CascadeType.DETACH, CascadeType.MERGE
//      , CascadeType.PERSIST, CascadeType.REFRESH})
//  private List<Product> products;

  public Unit() {
  }

  public Unit(String name) {
    this.name = name;
  }

//  public void addProductToUnit(Product product) {
//    if (products == null) {
//      products = new ArrayList<>();
//    }
//    products.add(product);
//    product.setUnit(this);
//  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

//  public List<Product> getProducts() {
//    return products;
//  }
//
//  public void setProducts(List<Product> products) {
//    this.products = products;
//  }

  @Override
  public String toString() {
    return "Unit{" +
        "name='" + name + '\'' +
        '}';
  }
}
