import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc152 {
  private static int maxProduct(int[] nums){
    int l = nums.length;
    int[] memo = new int[l];
    List<int[]> range = new ArrayList<>();
    int i = 0;
    int j;
    int ans = nums[0];
    int temp =1;
    boolean zero = false;
    // prefix multiple array
    for (int k=0;k<l;k++){
      if (nums[k]==0) {
        temp =1;
        memo[k] = 0;
        continue;
      }
      memo[k] = nums[k] * temp;
      temp = memo[k];
    }
    // get subarray index between zero
    while (i < l){
      j = 0;
      if (nums[i]!=0){
        while (i+j<l && nums[i+j]!=0) j++;
        range.add(new int[]{i,i+j});
        i+=j;
      }
      else {
        i++;
        zero = true;
      }
    }
    // check for -ve num and get extreme end.
    for (int[] r : range){
      // no or even -ve num
      if (memo[r[1]-1] >= 0) {
        ans = Math.max(ans, memo[r[1]-1]);
        continue;
      }
      //odd -ve num
      i = r[0];
      j = r[1] - 1;
      while (i < r[1] && nums[i]>=0) i++;
      while (j >= r[0] && nums[j]>=0) j--;
      if (i==j){
        if (r[1]-r[0]==1) temp = nums[r[0]];
        else{
          if (i == r[0]) temp = memo[r[1]-1] / memo[i];
          else if (i==r[1]-1) temp = memo[r[1]-2]; 
          else temp = Math.max(memo[i-1], memo[r[1]-1]/memo[i]);
        }
      }
      else temp = Math.max(memo[j-1], memo[r[1]-1]/memo[i]);
      ans = Math.max(temp,ans);
    }
    return (zero && ans < 0)?0:ans;
  }
  public static void main(String[] args) {
    int[] nums = {2,3,-2,4};
    System.out.println( maxProduct(nums));
  }
}
