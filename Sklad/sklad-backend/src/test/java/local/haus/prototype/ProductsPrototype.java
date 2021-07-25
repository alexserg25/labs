package local.haus.prototype;

import static local.haus.prototype.SuppliersPrototype.aSupplier;
import static local.haus.prototype.UnitsPrototype.aUnit;

import local.haus.persist.Product;
import local.haus.persist.Unit;

public class ProductsPrototype {

  public static Product aProduct() {
    Product product = new Product(
        "Плюшевый мишка"
        , 777
        , 100
        );

    product.setUnit(aUnit());
    product.setSupplier(aSupplier());
    return product;
  }
}
