import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class lc673 {
  
  private static int findNumberOfLIS(int[] nums) {
    int len = nums.length;
    int[] dp = new int[len];
    int longest=1;
    int cp;
    Set<List<Integer>> memo = new HashSet<>();
    List<Integer> seq;
    dp[0]=1;
    for (int i=1; i<len;i++){
      cp=0;
      seq = new LinkedList<>();
      while (cp<i){
        
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    int[] nums = {1,3,5,4,7};
    System.out.println( findNumberOfLIS(nums) );
  }
}
