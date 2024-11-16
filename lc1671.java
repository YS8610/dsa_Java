public class lc1671 {

  private static int minimumMountainRemovals(int[] nums) {
    int l = nums.length;
    int ans = l;
    int[] lis = new int[l];
    int[] lds = new int[l];
    int tmp = 0;
    lis[0] = 1;
    lds[l - 1] = 1;
    for (int i = 1; i < l; i++) {
      tmp = 0;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) tmp = Math.max(tmp, lis[j]);
      }
      lis[i] = tmp + 1;
    }
    for (int i = l - 2; i >= 0; i--) {
      tmp = 0;
      for (int j = l - 1; j > i; j--) {
        if (nums[i] > nums[j]) tmp = Math.max(tmp, lds[j]);
      }
      lds[i] = tmp + 1;
    }
    for (int i = 1; i < l - 1; i++) {
      if (lis[i] == 1 || lds[i] == 1) continue;
      ans = Math.min(ans, i + 1 - lis[i] + l - i - lds[i]);
    }
    return ans;
  }
  public static void main(String[] args) {
    int[] nums = {2,1,1,5,6,2,3,1};
    System.out.println(minimumMountainRemovals(nums));
  }
}
