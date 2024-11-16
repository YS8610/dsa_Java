import java.util.Arrays;

public class lc3254 {
  private static int[] resultsArray(int[] nums, int k) {
    if (k==1) return nums;
    int l = nums.length;
    int[] ans = new int[l-k+1];
    int rp;
    out:
    for (int i=0, n=l-k;i<=n;i++){
      if (i >0){
        if (ans[i-1] !=-1){
          if (nums[i+k-1] - ans[i-1]==1){
            ans[i] = ans[i-1]+1;
            continue;
          }
        }
      }
      rp = 0;
      while (i+rp<l && rp <k-1){
        if (nums[i+rp+1]-nums[i+rp]==1) rp++;
        else {
          for (int tmp=i+rp ;i<=tmp && i<=n;i++) ans[i] = -1;
          i--;
          continue out;
        }
      }
      if (rp==k-1) ans[i]=nums[i+rp];
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3,4,3,1,2,3,5};
    int k = 3;
    System.out.println(Arrays.toString(resultsArray(nums, k)));
  }
}
