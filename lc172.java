import java.math.BigInteger;

public class lc172 {
  private static int trailingZeroes(int n) {
    if (n>10000) return 0;
    String result = new lc172().factorial(n);
    int resultLen = result.length();
    int factorialAns = 0;
    for (int i = resultLen-1; i>=0;i--){
      if (!result.substring(i, i+1).equals("0")) return factorialAns;
      factorialAns++;
    }
    return factorialAns;
  }

  private String factorial(int n){
    BigInteger ans = BigInteger.ONE;
    for (int i=1; i<=n;i++){
      ans = ans.multiply( BigInteger.valueOf(i));
    }
    return String.valueOf(ans);
  }

  public static void main(String[] args) {
    int n = 10000;
    System.out.println( trailingZeroes(n) );
    // System.out.println( factorial(n) );

  }
}
