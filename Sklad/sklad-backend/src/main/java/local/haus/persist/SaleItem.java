package local.haus.persist;

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
@Table(name = "sale_items")
public class SaleItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id"
      , nullable = false)
  private int id;

//  @Column(name = "product_id"
//      , nullable = false)
//  private int productId;

  @Column(name = "count"
      , nullable = false)
  private int count;

  @Column(name = "price"
      , nullable = false)
  private int price;

//  @Column(name = "sale_id"
//      , nullable = false)
//  private int saleId;

  @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE
      , CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinColumn(name = "product_id")
  private Product product;

  @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE
      , CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinColumn(name = "sale_id")
  private Sale sale;

  public SaleItem() {
  }

  public SaleItem(int count, int price) {
    this.count = count;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Sale getSale() {
    return sale;
  }

  public void setSale(Sale sale) {
    this.sale = sale;
  }

  @Override
  public String toString() {
    return "SaleItem{" +
        "count=" + count +
        ", price=" + price +
        '}';
  }
}
