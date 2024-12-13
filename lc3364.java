import java.util.List;

public class lc3364 {
  private static int subarray(List<Integer> nums, int l){
    int sum=0;
    int ans=-1;
    for (int i=0, n=nums.size()-l; i<=n;i++){
      if (i==0){
        for (int j =0; j< l;j++)
          sum += nums.get(j); 
        if (sum >0 && ans ==-1) ans = sum;
        continue;
      }
      sum = sum - nums.get(i-1) + nums.get(i+l-1);
      if (sum <= 0) continue;
      if (ans < 0) ans = sum;
      else ans = Math.min(ans, sum);
    }
    return ans;
  }
  
  
  private static int minimumSumSubarray(List<Integer> nums, int l, int r) {
    int ans = -1;
    int tmp;
    for (int i =l; i<=r;i++){
      tmp = subarray(nums, i);
      if (tmp == -1) continue;
      if (tmp > 0){
        if (ans==-1) ans = tmp;
        else ans = Math.min(ans, tmp);
      } 
    }
    return ans;
  }

  public static void main(String[] args) {
    List<Integer> nums = List.of(3, -2, 1, 4);
    int  l = 2, r = 3;
    System.out.println(minimumSumSubarray(nums, l, r));
  }
}
