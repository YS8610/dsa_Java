public class lc477 {
  public int totalHammingDistance(int[] nums) {
    int ans = 0;
    int[] bitmap = new int[32];
    for (int n : nums)
      for (int i = 0; i < 32; i++)
        bitmap[i] += (n & (1 << i)) == 0 ? 0 : 1;
    for (int n : nums)
      for (int i = 0; i < 32; i++)
        ans += (n & (1 << i)) == 0 ? bitmap[i] : 0;
    return ans;
  }
}
