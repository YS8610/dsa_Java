import java.util.Arrays;

public class lc307 {

  int[] dp;

  public lc307(int[] nums) {
    int len = nums.length;
    this.dp = new int[len];
    this.dp[0] = nums[0];
    for (int i = 1; i < len; i++) this.dp[i] = this.dp[i - 1] + nums[i];
  }

  public void update(int index, int val) {
    int prev;
    if (index == 0) prev = this.dp[0]; 
    else prev = this.dp[index] - this.dp[index - 1];
    this.dp = Arrays.copyOf(this.dp, this.dp.length);
    for (int i =index,n=this.dp.length;i<n;i++){
      this.dp[i] = this.dp[i] - prev + val;
    }
  }

  public int sumRange(int left, int right) {
    if (left==0 && right ==0) return this.dp[0];
    if (left==0) return this.dp[right];
    return this.dp[right] - this.dp[left-1];
  }

  public static void main(String[] args) {
    int[] test = {1,3,5};
    lc307 a = new lc307(test);
    System.out.println(a.sumRange(0, 2));
    a.update(1, 2);
    System.out.println(a.sumRange(0, 2));
  }
}
