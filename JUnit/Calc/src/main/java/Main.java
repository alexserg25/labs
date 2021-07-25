import java.util.Scanner;

public class Main {

  final private static String operators = "[+\\-*/^]";

  public static void main(String[] args) {
    Main app = new Main();
    app.showOperation();
    String expression = app.readString();

//    String expression = "1001001110  +  1011010";
    app.goOperation(expression);

  }

  private void showOperation() {
    int lenRepeat = 50;

    String welcome = "<=== Input of binary operations! ===>";
    int welcomeSpace = (lenRepeat - welcome.length()) / 2;

    System.out.println("-".repeat(lenRepeat));
    System.out.println(" ".repeat(welcomeSpace) + welcome + " ".repeat(welcomeSpace));
    System.out.println("-".repeat(lenRepeat));
    System.out.println("Addition operation          (val1 + val2);");
    System.out.println("Subtraction operation       (val1 - val2);");
    System.out.println("Multiplication operation    (val1 * val2);");
    System.out.println("Division operation          (val1 / val2);");
    System.out.println("Addition operation modulo 2 (val1 ^ val2);");
    System.out.println("-".repeat(lenRepeat));
  }

  private boolean checkParameters(String[] list) {
    if (list.length < 2) {
      System.out.println("==> Missing parameters");
      return false;
    } else if (list.length > 2) {
      System.out.println("==> Many parameters");
      return false;
    } else if (list[0].replaceAll("[^01]", "").length() == 0
        || list[1].replaceAll("[^01]", "").length() == 0) {
      System.out.println("==> Empty one or more parameters");
      return false;
    }

    return true;
  }

  private void goOperation(String expression) {
    String[] list = (expression.split(operators));

    if (!checkParameters(list)) {
      System.exit(1);
    }

    String operator = expression.replaceAll("[^" + operators + "]", "");

    String sVal1 = list[0].replaceAll("[^01]", "");
    String sVal2 = list[1].replaceAll("[^01]", "");

    System.out.println("val1 = " + sVal1);
    System.out.println("val2 = " + sVal2);

    Calculator calculator = new Calculator();
    String res;
    switch (operator) {
      case "+":
        res = calculator.getSum(sVal1, sVal2);
        break;
      case "-":
        res = calculator.getSubtract(sVal1, sVal2);
        break;
      case "*":
        res = calculator.getMultiply(sVal1, sVal2);
        break;
      case "/":
        res = calculator.getDivide(sVal1, sVal2);
        break;
      case "^":
        res = calculator.getModulo2(sVal1, sVal2);
        break;
      default:
        res = "0";
    }
    System.out.println(sVal1 + " " + operator + " " + sVal2 + " = " + res);

  }


  private String readString() {
    Scanner scanner = new Scanner(System.in);
    String res;
    do {
      System.out.print("Input binary operation: ");
      res = scanner.nextLine();
    } while (res.length() == 0);
    return res;
  }

}