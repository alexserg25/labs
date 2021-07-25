package local.haus.persist;

import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "name"
      , nullable = false)
  private String name;

  @Column(name = "count"
      , nullable = false)
  private int count;

  @Column(name = "price"
      , nullable = false)
  private int price;

  @Column(name = "date_receipt"
      , nullable = true
      , columnDefinition = "TIMESTAMP default 'CURRENT_TIMESTAMP'"
      , insertable = false)
  private Timestamp date;


  @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE
      , CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinColumn(name = "supplier_id")
  private Supplier supplier;

  @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE
      , CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinColumn(name = "unit_id")
  private Unit unit;

  public Product() {
  }

  public Product(String name, int count, int price) {
    this.name = name;
    this.count = count;
    this.price = price;
//    this.date = date;
  }

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

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public Timestamp getDate() {
    return date;
  }

  public void setDate(Timestamp date) {
    this.date = date;
  }

  public Supplier getSupplier() {
    return supplier;
  }

  public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
  }

  public Unit getUnit() {
    return unit;
  }

  public void setUnit(Unit unit) {
    this.unit = unit;
  }

  @Override
  public String toString() {
    return "Product{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", count=" + count +
        ", price=" + price +
        '}';
  }
}
