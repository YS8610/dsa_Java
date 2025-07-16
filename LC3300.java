public class lc3300 {
  
  private static int minElement(int[] nums) {
    int ans = Integer.MAX_VALUE;
    int tmp = 0;
    for (int n:nums){
      tmp = 0;
      while (n/10 != 0){
        tmp += n%10;
        n /=10;
      }
      tmp+= n%10;
      ans = Math.min(ans, tmp);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3 ,4};
    System.out.println(minElement(nums));
  }
}
