public class lc29 {
  private static int divide(int dividend, int divisor) {
    int absDividend = Math.abs(dividend);
    int absDivisor = Math.abs(divisor);
    if (absDividend < absDivisor) return 0;
    int counter =0;
    while (absDividend> absDivisor){
      absDividend -= absDivisor;
      counter++;
    }
    counter = counter > Math.pow(2, 31) - 1? 231 - 1: counter;
    if ( (dividend<0 && divisor>0)  || (dividend>0 && divisor<0) ) counter*=-1;
    return counter;
  }
  public static void main(String[] args) {
    int dividend = -2147483648, divisor = -1;
    System.out.println( divide(dividend,divisor) );
  }
}
