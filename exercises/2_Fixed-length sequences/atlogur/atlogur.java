import java.util.Scanner;

public class atlogur {
  int[][] knights; // int[health][strength]

  public atlogur(int n) {
    knights = new int[n][2];
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt(); // number of knights

    atlogur a = new atlogur(n);

    for (int i = 0; i < n; i++) {
      int h = scanner.nextInt(); // health
      int s = scanner.nextInt(); // strength

      a.assignValues(i, h, s);
    }
    scanner.close();

    int winner = a.fight(n); // returns winning index
    System.out.println(winner + 1);
  }

  public void assignValues(int i, int h, int s) {
    knights[i][0] = h;
    knights[i][1] = s;
  }

  public void strike(int attacker, int defender) {
    knights[defender][0] = knights[defender][0] - knights[attacker][1];
  }

  public boolean fighting(int i, int j) {
    return knights[i][0] > 0 && knights[j][0] > 0;
  }

  public int winner(int i, int j) {
    if (knights[i][0] > 0) return i;
    else if (knights[j][0] > 0) return j;
    else return -1;
  }

  public int fight(int n) {
    int i = 0;

    for (int j = 1; j < n; j++) {
      int turn = i;
      while (fighting(i, j)) {
        if (turn == i) {
          strike(i, j);
          turn = j;
        } else {
          strike(j, i);
          turn = i;
        }
      }
      i = winner(i, j);
      if (i == -1) System.out.println("No winner, something went wrong");
    }
    return i;
  }
}
