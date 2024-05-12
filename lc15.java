import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc15 {
  private static List<List<Integer>> threeSum(int[] nums){
    Arrays.sort(nums);
    Set<List<Integer>> ans = new HashSet<>();
    int len = nums.length;
    for (int i=0; i<len-2;i++){
      if (i-1>=0 && nums[i]==nums[i-1]) continue; 
      int j = i+1;
      int k = len-1;
      while(j<k){
        int result = nums[i] + nums[j] + nums[k];
        if (result == 0) {
          ans.add( List.of(nums[i], nums[j], nums[k]));
          j++;
        }
        else if (result>0) k--;
        else j++;
      }
    }
    return ans.stream().toList();
  }


  public static void main(String[] args) {
    int[] nums = {-1,0,1,2,-1,-4};
    System.out.println( threeSum(nums).toString() );
  }
}
