public class lc633 {
  private static boolean judgeSquareSum(int c) {
    if (c == 0) return true;
    int n = (int)Math.sqrt(c);
    double res;
    for (int i = 1; i<=n; i++){
      res = Math.sqrt(c - i * i);
      if ((int) res * (int) res + i * i == c)
        return true;
    }
    return false;
  }

  public static void main(String[] args) {
    int c = 5;
    System.out.println(judgeSquareSum(c));
  }
}
