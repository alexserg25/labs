package table_struct;

import java.sql.Timestamp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import table_struct.entity.*;

public class SuppliersTest {

  public static void main(String[] args) {
    SessionFactory factory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Unit.class)
        .addAnnotatedClass(Product.class)
        .addAnnotatedClass(Supplier.class)
        .buildSessionFactory();

    Session session = null;
    try {
      session = factory.getCurrentSession();

      Unit unit = new Unit("Килло");
      Supplier supplier = new Supplier("OOO Strij", 12345, 1111
          , "Petya", "123", "Moskov");

      Product product = new Product("Viski", 10, 1000);


      session.beginTransaction();

      product.setSupplier(supplier);
      product.setUnit(unit);

//      session.persist(unit);
//      session.persist(supplier);
      session.persist(product);

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
