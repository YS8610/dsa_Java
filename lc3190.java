public class lc3190 {
  public int minimumOperations(int[] nums) {
    int ans = 0;
    int tmp;
    for (int n : nums) {
      tmp = n % 3;
      ans += tmp == 2 ? 1 : tmp;
    }
    return ans;
  }
}
