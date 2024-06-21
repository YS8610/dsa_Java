public class lc1052 {

  private static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
    int len = customers.length;
    int[] unsatified = new int[len];
    int satified = 0;
    int max = 0;
    int window = 0;
    for (int i = 0; i < len; i++) {
      unsatified[i] = customers[i] * grumpy[i];
      satified += grumpy[i] == 0 ? customers[i] : 0;
    }
    for (int i = 0; i < minutes; i++) max += unsatified[i];
    window = max;
    for (int i = 1, n = len - minutes; i <= n; i++) {
      window = window - unsatified[i - 1] + unsatified[i + minutes - 1];
      max = Math.max(max, window);
    }
    return satified + max;
  }

  public static void main(String[] args) {
    int[] customers = {1,0,1,2,1,1,7,5}, grumpy = {0,1,0,1,0,1,0,1};
    int minutes = 3;
    System.out.println(maxSatisfied(customers, grumpy, minutes));
  }
}
