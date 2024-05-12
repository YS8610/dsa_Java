public class lc1342 {
  private static int numberOfSteps(int num) {
    int ans = 0;
    while (num != 0) {
      ans++;
      if (num % 2 == 0) num /= 2;
      else num --;
    }
    return ans;
  }

  public static void main(String[] args) {
    int num = 8;
    System.out.println(numberOfSteps(num));
  }
}
