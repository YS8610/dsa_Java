public class lc1295 {
  static public int findNumbers(int[] nums) {
    int ans = 0;
    for (int n : nums)
      ans += can(n) ? 1 : 0;
    return ans;
  }

  static private boolean can(int num) {
    int ans = 0;
    while (num != 0) {
      ans++;
      num /= 10;
    }
    return (ans & 1) == 0;
  }

  public static void main(String[] av){
    int[] nums = {12,345,2,6,7896};
    System.out.println(findNumbers(nums));
  }
}
