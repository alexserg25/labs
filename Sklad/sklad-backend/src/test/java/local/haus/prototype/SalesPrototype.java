package local.haus.prototype;

import static local.haus.prototype.CustomersPrototype.aCustomer;
import static local.haus.prototype.SuppliersPrototype.aSupplier;
import static local.haus.prototype.UnitsPrototype.aUnit;

import local.haus.persist.Product;
import local.haus.persist.Sale;

public class SalesPrototype {

  public static Sale aSale() {
    Sale sale = new Sale(100);

    sale.setCustomer(aCustomer());
    return sale;
  }
}
