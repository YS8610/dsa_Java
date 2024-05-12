public class lc324 {
  private static  boolean isPowerOfFour(int n) {
    if (n<=0) return false;
    if (n==1) return true;
    if (n%2!=0) return false;

    double x = Math.log(n) / Math.log(4);
    if (x%1==0) return true;
    return false;
  }


  public static void main(String[] args) {
    int n = 17;
    System.out.println( isPowerOfFour(n) );
  }

}
