package local.haus.prototype;

import local.haus.persist.Supplier;

public class SuppliersPrototype {

  public static Supplier aSupplier() {
    return new Supplier(
        "OOO Iskra"
        , 1112223334
        , 555443335
        , "Ivanov"
        , "10-10-25"
        , "Lenina 2");
  }
}
