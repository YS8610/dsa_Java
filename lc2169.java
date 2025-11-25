public class lc2169 {
  public int countOperations(int num1, int num2) {
    int ans = 0;
    while (!(num1 == 0 || num2 == 0)) {
      if (num1 >= num2) {
        ans += num1 / num2;
        num1 %= num2;
        continue;
      }
      ans += num2 / num1;
      num2 %= num1;
    }
    return ans;
  }
}
