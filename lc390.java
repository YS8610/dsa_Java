public class lc390 {

  static public int lastRemaining(int n) {
    return recursion(1, n, 0, true);
  }

  static private int recursion(int head, int no, int time, boolean start) {
    if (no == 1)
      return head;
    if (start) {
      head += (1 << time);
      return recursion(head, no / 2, time + 1, !start);
    }
    if ((no & 1) == 1) {
      head += (1 << time);
      return recursion(head, no / 2, time + 1, !start);
    }
    return recursion(head, no / 2, time + 1, !start);
  }

  public static void main(String[] args) {
    int n =10;
    System.out.println(lastRemaining(n));
  }
}
