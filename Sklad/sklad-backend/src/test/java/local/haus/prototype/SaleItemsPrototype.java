package local.haus.prototype;

import static local.haus.prototype.CustomersPrototype.aCustomer;
import static local.haus.prototype.ProductsPrototype.aProduct;
import static local.haus.prototype.SalesPrototype.aSale;

import local.haus.persist.Sale;
import local.haus.persist.SaleItem;

public class SaleItemsPrototype {

  public static SaleItem aSaleItem() {
    SaleItem saleItem = new SaleItem(
        5
        , 100
    );

    saleItem.setSale(aSale());
    saleItem.setProduct(aProduct());

    return saleItem;
  }
}
