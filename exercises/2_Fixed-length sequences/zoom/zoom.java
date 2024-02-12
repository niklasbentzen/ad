import java.util.Scanner;

public class zoom {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int k = scanner.nextInt();

    int j = 0;
    for (int i = 1; i <= n; i++) {
      int o = scanner.nextInt();
      if (i % k == 0) { System.out.println(o); j++; }
    }
  }
}
