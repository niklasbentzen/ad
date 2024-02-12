import java.util.Arrays;
import java.util.Scanner;

public class coffeecupcombo {
  private int[] lectures;
  private int cupsInHands;
  private int survived;

  public coffeecupcombo(int n) {
    survived = 0;
    lectures = new int[n];
    cupsInHands = 0;
  }

  private int beginDay() {
    for (int i : lectures) {
      switch (i) {
        case 1 :
          fillUp();
          break;
        case 0 :
          if (cupsInHands > 0) drinkOne();
          break;
      }
    }
    return survived;
  }

  private void fillUp() {
    cupsInHands = 2;
    survived++;
  }

  private void drinkOne() {
    cupsInHands = cupsInHands - 1;
    survived++;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine()); // number of lectures to attend
    coffeecupcombo c = new coffeecupcombo(n);

    c.lectures = Arrays.stream(scanner.nextLine().split(""))
            .mapToInt(Integer::parseInt)
            .toArray();

    System.out.println(c.beginDay());
  }
}
