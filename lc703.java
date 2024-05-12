import java.util.Arrays;

public class lc703 {
  int k;
  int[] nums;
  int kthno;
  int kthno1;

  public lc703(int k, int[] nums) {
    this.k = k;
    this.nums = nums;
    Arrays.sort(this.nums);
    this.kthno = this.nums[k-1];
    this.kthno1 = this.nums[k-2];

  }
  
  public int add(int val) {
    if (val<= this.kthno) return this.kthno;
    if (val<=this.kthno1) return val;
    else return this.kthno1;
  }
}
