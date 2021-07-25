package local.haus.persist;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id"
      , nullable = false)
  private int id;

  @Column(name = "name"
      , nullable = false)
  private String name;

  @Column(name = "inn"
      , nullable = false)
  private long inn;

  @Column(name = "kpp"
      , nullable = false)
  private long kpp;

  @Column(name = "contact_name"
      , nullable = false)
  private String contactName;

  @Column(name = "telephone_number"
      , nullable = false)
  private String telephone;

  @Column(name = "address"
      , nullable = false)
  private String address;

  public Customer() {
  }

  public Customer(String name, long inn, long kpp, String contactName, String telephone,
      String address) {
    this.name = name;
    this.inn = inn;
    this.kpp = kpp;
    this.contactName = contactName;
    this.telephone = telephone;
    this.address = address;
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

  public long getInn() {
    return inn;
  }

  public void setInn(long inn) {
    this.inn = inn;
  }

  public long getKpp() {
    return kpp;
  }

  public void setKpp(long kpp) {
    this.kpp = kpp;
  }

  public String getContactName() {
    return contactName;
  }

  public void setContactName(String contactName) {
    this.contactName = contactName;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "Customer{" +
        "name='" + name + '\'' +
        ", inn=" + inn +
        ", kpp=" + kpp +
        ", contactName='" + contactName + '\'' +
        ", telephone='" + telephone + '\'' +
        ", address='" + address + '\'' +
        '}';
  }
}
