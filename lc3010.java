public class lc3010 {
  public int minimumCost(int[] nums) {
    int[] table = new int[51];
    int l = nums.length;
    int ans = nums[0];
    for (int i = 1; i < l; i++)
      table[nums[i]]++;
    for (int i = 0, count = 2; i < 51 && count > 0; i++)
      while (table[i] > 0 && count > 0) {
        ans += i;
        table[i]--;
        count--;
      }
    return ans;
  }
}
