import java.util.Arrays;

public class lc2706 {
  private static int buyChoco(int[] prices, int money) {
    Arrays.sort(prices);
    int leftover = money -prices[0] - prices[1];
    return leftover>=0?leftover:money;
  }

  public static void main(String[] args) {
    int[] prices = {3,2,3};
    int money = 3;
    System.out.println(buyChoco(prices, money));
  }
}
