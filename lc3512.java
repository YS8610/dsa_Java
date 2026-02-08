public class lc3512 {
  public int minOperations(int[] nums, int k) {
    int sum = 0;
    for (int n : nums)
      sum += n;
    return sum % k;
  }
}
