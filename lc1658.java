public class lc1658 {
  static public int minOperations(int[] nums, int x) {
    int l = nums.length;
    int target = -x;
    int len = 0;
    int lp = 0, rp = 0;
    for (int n : nums)
      target += n;
    if (target == 0)
      return l;
    int tmp = 0;
    while (lp < l) {
      if (lp > rp){
        rp = lp;
        tmp = 0;
      }
      // move rp
      while (rp < l && tmp <= target) {
        tmp += nums[rp];
        if (tmp == target)
          len = Math.max(len, rp - lp + 1);
        rp++;
      }
      // move lp
      tmp -= nums[lp];
      lp++;
      if (tmp == target)
        len = Math.max(len, rp - lp);
    }
    return len == 0 ? -1 : l - len;
  }

  public static void main(String[] args){
    int[] nums = {3,2,20,3,1,1,3};
    int x = 10;
    System.out.println(minOperations(nums, x));
  }
}
