import java.util.ArrayList;
import java.util.List;

public class lc442 {
  private static List<Integer> findDuplicates(int[] nums){
    List<Integer> ans = new ArrayList<>();
    int num = 0;
    for(int i =0, n=nums.length; i<n;i++){
      num = Math.abs(nums[i]);
      if (nums[num-1]<0) {
        ans.add(num);
        continue;
      }
      nums[num-1] *= -1;
    }
    return ans;
  }
  public static void main(String[] args) {
    int[] nums = {1};
    System.out.println( findDuplicates(nums).toString() );

  }
}
