public class lc1518 {
  private static int numWaterBottles(int numBottles, int numExchange) {
    int ans = numBottles;
    int empty = ans;
    int exchanged = 0;
    while (empty / numExchange > 0){
      exchanged = empty / numExchange;
      ans += exchanged;
      empty = empty % numExchange + exchanged;
    }
    return ans;
  }

  public static void main(String[] args) {
    int numBottles = 15, numExchange = 4;
    System.out.println(numWaterBottles(numBottles, numExchange));
  }
}
