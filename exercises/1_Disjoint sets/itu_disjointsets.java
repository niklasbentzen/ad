import java.util.Scanner;

public class itu_disjointsets {
  private int[] id;

  public itu_disjointsets(int n) {
    this.id = new int[n];
    for (int i = 0; i < n; i++) id[i] = i;
  }

  public void query(int s, int t) {
    if (connected(s, t)) System.out.println(1);
    else if (!connected(s, t)) System.out.println(0);
  }

  public void union(int s, int t) {
    int sID = find(s);
    int tID = find(t);
    if (sID == tID) return;

    id[sID] = t;
  }

  public void move(int s, int t) {
    int sID = find(s);
    int tID = find(t);
    if (sID == tID) return;

    int newRoot = -1;

    for (int i = 0; i < id.length; i++) {
      if (s == id[i]) {                     // if id[i] points to 's'
        if ((sID == s) && (sID != i)) {     // if 's' refers to itself && root of s is not the same as i
          if (newRoot == -1) {              // first time 'i' is below 's' in the tree
            id[i] = i; newRoot = i;         // refers i to itself (new root)
          } else {                          // not the first time
            id[i] = newRoot;                // refers 'i' to newRoot (the first 'i' found)
          }
        }
        else id[i] = sID; // else point 'i' to root of 's'
      }
    }
    id[s] = t; // points s to t
  }

  public int find(int p) { while (p != id[p]) p = id[p]; return p; }

  public boolean connected(int p, int q) { return find(p) == find(q); }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt(); // number of singletons
    int q = scanner.nextInt(); // number of operations

    itu_disjointsets uf = new itu_disjointsets(n);

    for (int i = 0; i < q; i++) {
      int operation = scanner.nextInt();

      int s = scanner.nextInt();
      int t = scanner.nextInt();

      switch (operation) {
        case 0: uf.query(s, t); break;
        case 1: uf.union(s, t); break;
        case 2: uf.move(s, t); break;
      }
    } scanner.close();
  }
}