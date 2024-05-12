public class lc3005 {
  private static int maxFrequencyElements(int[] nums) {
    int[] memo = new int[101];
    int max = 0;
    int ans = 0;
    for (int n :nums) memo[n]++;
    for (int i =0; i<101;i++) max = Math.max(max, memo[i]);
    for (int m : memo) ans += m==max?1:0;
    return ans*max;
  }
  public static void main(String[] args) {
    int[] nums = {1,2,2,3,1,4};
    System.out.println(maxFrequencyElements(nums));
  }
}
