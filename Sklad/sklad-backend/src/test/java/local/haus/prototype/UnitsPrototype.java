package local.haus.prototype;

import local.haus.persist.Unit;

public class UnitsPrototype {

  public static Unit aUnit() {
    Unit unit = new Unit();
    unit.setName("Штук");
    return unit;
  }
}
