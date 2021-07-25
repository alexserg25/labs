import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.*;

class CalculatorDynamicTest {
//  private final String pathForDir = "src/test/resources/";
  private final String pathForDir = "src\\test\\resources\\";
  private Calculator calculator;

  @BeforeEach
  void setup() {
    calculator = new Calculator();
  }

  private static class DataForCalc {
    final String val1;
    final String val2;
    final String expected;

    private DataForCalc(String val1, String val2, String expected) {
      this.val1 = val1;
      this.val2 = val2;
      this.expected = expected;
    }

    public String getVal1() {
      return val1;
    }

    public String getVal2() {
      return val2;
    }

    public String getExpected() {
      return expected;
    }
  }

  private List<DataForCalc> getDataFromFile(String fileName) throws IOException {
    Path file = Paths.get(pathForDir + fileName);
    List<String> list = Files.readAllLines(file);

    List<DataForCalc> data = new ArrayList<>();
    String[] val;
    for (String str : list) {
      if (str.replaceAll("[^01,]", "").length() > 4) {
        val = str.split(",");
        data.add(new DataForCalc(
            val[0].replaceAll("[^01,]", ""),
            val[1].replaceAll("[^01,]", ""),
            val[2].replaceAll("[^01,]", ""))
        );
      }
    }
    return data;
  }

  void readItems() throws IOException {
    Path file = Paths.get(pathForDir + "divideNew.csv");
    List<String> list = Files.readAllLines(file);

    Stream<Object> stream = Arrays.stream(list.toArray());
    stream
        .filter(str -> ((String) str).replaceAll("[^01,]", "").length() > 5
        )
        .forEach(System.out::println);
  }

  @TestFactory
  Stream<DynamicTest> getSumDynamic() throws IOException {
    List<DataForCalc> data = getDataFromFile("sum.csv");

    return data
        .stream()
        .filter(str -> str.getVal1().replaceAll("[^01,]", "").length() > 0)
        .map(str -> dynamicTest("Testing for sum: " + str.getVal1() + " + " + str.getVal2(),
            () -> assertEquals(str.getExpected(), calculator.getSum(str.getVal1(), str.getVal2()))));
  }

  @TestFactory
  Stream<DynamicTest> getSubtractDynamic() throws IOException {
    List<DataForCalc> data = getDataFromFile("subtract.csv");

    return data
        .stream()
        .filter(str -> str.getVal1().replaceAll("[^01,]", "").length() > 0)
        .map(str -> dynamicTest("Testing for subtract: " + str.getVal1() + " - " + str.getVal2(),
            () -> assertEquals(str.getExpected(), calculator.getSubtract(str.getVal1(), str.getVal2()))));
  }


  @TestFactory
  Stream<DynamicTest> getMultiplyDynamic() throws IOException {
    List<DataForCalc> data = getDataFromFile("multiply.csv");

    return data
        .stream()
        .filter(str -> str.getVal1().replaceAll("[^01,]", "").length() > 0)
        .map(str -> dynamicTest("Testing for multiply: " + str.getVal1() + " * " + str.getVal2(),
            () -> assertEquals(str.getExpected(), calculator.getMultiply(str.getVal1(), str.getVal2()))));
  }


  @TestFactory
  Stream<DynamicTest> getDivideDynamic() throws IOException {
    List<DataForCalc> data = getDataFromFile("divide.csv");

    return data
        .stream()
        .filter(str -> str.getVal1().replaceAll("[^01,]", "").length() > 0)
        .map(str -> dynamicTest("Testing for divide: " + str.getVal1() + " / " + str.getVal2(),
            () -> assertEquals(str.getExpected(), calculator.getDivide(str.getVal1(), str.getVal2()))));
  }

  @TestFactory
  Stream<DynamicTest> getModulo2Dynamic() throws IOException {
    List<DataForCalc> data = getDataFromFile("modulo2.csv");

    return data
        .stream()
        .filter(str -> str.getVal1().replaceAll("[^01,]", "").length() > 0)
        .map(str -> dynamicTest("Testing for modulo2: " + str.getVal1() + " ^ " + str.getVal2(),
            () -> assertEquals(str.getExpected(), calculator.getModulo2(str.getVal1(), str.getVal2()))));
  }
}