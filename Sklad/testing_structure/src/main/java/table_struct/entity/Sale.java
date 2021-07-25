package table_struct.entity;

import java.sql.Timestamp;
import javax.persistence.*;

@Entity
@Table(name = "sales")
public class Sale {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id"
      , nullable = false)
  private int id;

  @Column(name = "sum"
      , nullable = true)
  private int sum;

  @Column(name = "date_sale"
      , nullable = false
      , columnDefinition = "TIMESTAMP default 'CURRENT_TIMESTAMP'"
      , insertable = false)
  private Timestamp date;

  @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE
      , CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinColumn(name = "customer_id")
  private Customer customer;

  public Sale() {
  }

  public Sale(int sum) {
    this.sum = sum;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getSum() {
    return sum;
  }

  public void setSum(int sum) {
    this.sum = sum;
  }

  public Timestamp getDate() {
    return date;
  }

  public void setDate(Timestamp date) {
    this.date = date;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  @Override
  public String toString() {
    return "Sale{" +
        "id=" + id +
        ", sum=" + sum +
        ", date=" + date +
        '}';
  }
}
