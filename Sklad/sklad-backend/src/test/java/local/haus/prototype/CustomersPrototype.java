package local.haus.prototype;

import local.haus.persist.Customer;

public class CustomersPrototype {

  public static Customer aCustomer() {
    return new Customer(
        "OOO Mechta"
        , 1111111
        , 5134532
        , "Petrov"
        , "21-55-25"
        , "Kirova 2");
  }
}
