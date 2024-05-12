public class lc50 {
  
  private static double myPow(double x, int n) {
    double ans = x;
    for(int i=1, m=Math.abs(n);i<m;i++) ans *= x;
    if (n>0) return ans;
    else {
      return 1d/ans;
    }
  }

  public static void main(String[] args) {
    double x = -2.00000;
    int n = -2;

    System.out.println( myPow(x, n) );
  }
}
