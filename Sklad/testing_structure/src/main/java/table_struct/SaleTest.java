package table_struct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import table_struct.entity.*;

public class SaleTest {

  public static void main(String[] args) {
    SessionFactory factory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Sale.class)
        .addAnnotatedClass(SaleItem.class)
        .addAnnotatedClass(Product.class)
        .addAnnotatedClass(Customer.class)
        .addAnnotatedClass(Supplier.class)
        .addAnnotatedClass(Unit.class)
        .buildSessionFactory();

    Session session = null;
    try {
      session = factory.getCurrentSession();

//      Customer customer = new Customer("OOO Vostok", 5555555, 456456
//          , "Vasya", "555777555", "Piter");
//      Sale sale = new Sale(0);


      session.beginTransaction();
      Customer customer = session.get(Customer.class, 2);
      Sale sale = session.get(Sale.class, 1);
      sale.setCustomer(customer);
      Product product = session.get(Product.class, 2);
//      Supplier supplier = session.get(Product.class, product.getSup)

      SaleItem saleItem = new SaleItem(1, product.getPrice());
      saleItem.setSale(sale);


//      session.persist(sale);

      session.getTransaction().commit();

//      session = factory.getCurrentSession();
//      session.beginTransaction();
//
//      Unit unit = session.get(Unit.class, 2);
//      session.delete(unit);
//      session.getTransaction().commit();

    } finally {
      session.close();
      factory.close();
    }
  }

}
