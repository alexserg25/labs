import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

class CalculatorTest {
//  private final String pathForDir = "src/test/resources/";
  private final String pathForDir = "src\\test\\resources\\";
  private  Calculator calculator;

  @BeforeEach
  void setup() {
    calculator = new Calculator();
  }

  @Nested
  @DisplayName("Parameterized Tests")
  class FromData {

    @ParameterizedTest
    @CsvSource({"001, 101, 110", "10, 101, 111", "101, 10, 111"})
    void getSumFromData(String val1, String val2, String expected) {
      assertEquals(expected, calculator.getSum(val1, val2));
    }

    @ParameterizedTest
    @CsvSource({"10, 01, 1", "110, 001, 101", "111, 001, 110"})
    void getSubtractFromData(String val1, String val2, String expected) {
      assertEquals(expected, calculator.getSubtract(val1, val2));
    }

    @ParameterizedTest
    @CsvSource({"10, 00, 0", "000, 001, 0", "111, 001, 111"})
    void getMultiplyFromData(String val1, String val2, String expected) {
      assertEquals(expected, calculator.getMultiply(val1, val2));
    }

    @ParameterizedTest
    @CsvSource({"0, 10, 0", "10, 01, 10", "110, 010, 11"})
    void getDivideFromData(String val1, String val2, String expected) {
      assertEquals(expected, calculator.getDivide(val1, val2));
    }

    @ParameterizedTest
    @CsvSource({"1001001, 1001, 1000000"
        , "100101 , 111 , 100010"
        , "100101 , 111 , 100010"})
    void getModulo2FromData(String val1, String val2, String expected) {
      assertEquals(expected, calculator.getModulo2(val1, val2));
    }
  }

  @Nested
  @DisplayName("Parameterized Tests from csv files")
  class FromFiles {

    @ParameterizedTest
    @CsvFileSource(files = pathForDir + "sum.csv", numLinesToSkip = 1)
    void getSumFromFile(String val1, String val2, String expected) {
      assertEquals(expected, calculator.getSum(val1, val2));
    }

    @ParameterizedTest
    @CsvFileSource(files = pathForDir + "subtract.csv", numLinesToSkip = 1)
    void getSubtractFromFile(String val1, String val2, String expected) {
      assertEquals(expected, calculator.getSubtract(val1, val2));
    }

    @ParameterizedTest
    @CsvFileSource(files = pathForDir + "multiply.csv", numLinesToSkip = 1)
    void getMultiplyFromFile(String val1, String val2, String expected) {
      assertEquals(expected, calculator.getMultiply(val1, val2));
    }

    @ParameterizedTest
      @CsvFileSource(files = pathForDir + "divide.csv", numLinesToSkip = 1)
    void getDivideFromFile(String val1, String val2, String expected) {
      assertEquals(expected, calculator.getDivide(val1, val2));
    }

    @ParameterizedTest
    @CsvFileSource(files = pathForDir + "modulo2.csv", numLinesToSkip = 1)
    void getModulo2FromFile(String val1, String val2, String expected) {
      assertEquals(expected, calculator.getModulo2(val1, val2));
    }
  }

  @Test
  @DisplayName("Division by zero is exception!")
  void divideSecondArgumentZero() {
    Exception ex = assertThrows(Exception.class, () -> calculator.getDivide("1", "0"));
    assertEquals(ex.getMessage(), "/ by zero", "Invalid error message received!");
  }
}