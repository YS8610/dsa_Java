public class lc3345 {
  private static boolean div(int n, int t){
    int prod = 1;
    while (n/10 != 0){
      prod *= n%10;
      n /=10;
    }
    prod *= n%10;
    return prod%t==0;
  }

  private static int smallestNumber(int n, int t) {
    boolean res = false;
    while (!res){
      res = div(n, t);
      n++;
    }
    return n-1;
  }

  public static void main(String[] args) {
    int n = 10, t = 2;
    System.out.println(smallestNumber(n, t));
  }
}
