import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import edu.princeton.cs.algs4.*;

public class itu_grades implements Comparable<itu_grades> {
  String name;
  Integer grade;
  Integer symbol;

  private static final Map<String, Integer> rankValues = Map.of(
"A", 1,
"B", 2,
"C", 3,
"D", 4,
"E", 5,
"FX", 6,
"F", 7
  );

  public itu_grades(String name, Integer grade, Integer symbol) {
    this.name = name;
    this.grade = grade;
    this.symbol = symbol;
  }

  @Override
  public int compareTo(itu_grades that) {
    if (this.grade.compareTo(that.grade) == 0) {
      if (this.symbol.compareTo(that.symbol) == 0) {
        if (this.name.compareTo(that.name) > 0) return 1;
        if (this.name.compareTo(that.name) < 0) return -1;
      }
      return this.symbol.compareTo(that.symbol);
    }
    return this.grade.compareTo(that.grade);
  }

  private static int calcSymbol(String symbol){
    String[] s = symbol.split("");

    if (s.length == 0) return 0;
    if (s[0].equals("+")) return s.length * -1;
    if (s[0].equals("-")) return s.length;
    return 0;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.nextLine();

    itu_grades[] a = new itu_grades[n];

    String regex = "(\\w+) (\\w+)([\\+\\-]*)";
    Pattern pattern = Pattern.compile(regex);

    for (int i = 0; i < n; i++) {
      String line = scanner.nextLine();
      Matcher matcher = pattern.matcher(line);

      if (matcher.find()) {
        itu_grades grade = new itu_grades(
                matcher.group(1),
                rankValues.get(matcher.group(2)),
                calcSymbol(matcher.group(3))

        );
        a[i] = grade;
      }
    }
    Merge.sort(a);

    for (itu_grades i : a) System.out.println(i.name);
  }
}
