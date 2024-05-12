public class lc303 {
  int[] memo;

  public lc303(int[] nums) {
    int n = nums.length;
    this.memo = new int[n];
    this.memo[0]=nums[0];
    for (int i=1;i<n;i++) this.memo[i] = this.memo[i-1]+nums[i];
  }
  
  public int sumRange(int left, int right) {
    if (left==0) return this.memo[right];
    else return this.memo[right] - this.memo[left-1];
  }
}
