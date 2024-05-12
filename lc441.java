public class lc441 {

  static private int arrangeCoins(int n){
    if (n==0) return 0;
    if (n==1) return 1;
    Long counter = 1L;
    Long sumofCoin = 1L;
    while (sumofCoin<n){
      counter++;
      sumofCoin = sumofCoin + counter;
    }
    return (int) (sumofCoin==n?counter:counter-1);
  }

  public static void main(String[] args) {
    System.out.println(arrangeCoins(9));
    // System.out.println(arrangeCoins(1957747793));
  }
}
