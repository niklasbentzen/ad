import edu.princeton.cs.algs4.*;
import java.util.Scanner;

public class itu_balance {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String w = scanner.nextLine();
    System.out.println(balance(w));
  }

  public static int balance(String w) {
    Stack<String> values = new Stack<>();

    for (String i : w.split("")) {

      if (i.equals("(") || i.equals("[")) {
        values.push(i);
      }

      else if (i.equals(")") || i.equals("]")) {
        if (values.isEmpty()) return 0;

        String val = values.pop();
        if (!val.equals("(") && i.equals(")")) { return 0; }
        if (!val.equals("[") && i.equals("]")) { return 0; }
      }
    }
    if (!values.isEmpty()) return 0;
    return 1;
  }
}
