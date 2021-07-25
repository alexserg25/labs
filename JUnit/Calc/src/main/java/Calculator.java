public class Calculator {

  protected String getSum(String val1, String val2) {
    int result = Integer.parseInt(val1, 2) + Integer.parseInt(val2, 2);
    return Integer.toBinaryString(result);
  }

  protected String getSubtract(String val1, String val2) {
    int result = Integer.parseInt(val1, 2) - Integer.parseInt(val2, 2);
    return Integer.toBinaryString(result);
  }

  protected String getMultiply(String val1, String val2) {
    int result = Integer.parseInt(val1, 2) * Integer.parseInt(val2, 2);
    return Integer.toBinaryString(result);
  }

  protected String getDivide(String val1, String val2) {
    int result = Integer.parseInt(val1, 2) / Integer.parseInt(val2, 2);
    return Integer.toBinaryString(result);
  }

  protected String getModulo2(String val1, String val2) {
    int result = Integer.parseInt(val1, 2) ^ Integer.parseInt(val2, 2);
    return Integer.toBinaryString(result);
  }
}