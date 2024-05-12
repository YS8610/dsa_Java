import java.util.HashMap;
import java.util.Map;

public class lc523 {
  
  private static boolean checkSubarraySum(int[] nums, int k) {
    int n = nums.length;
    int[] pSum = new int[n];
    pSum[0] = nums[0];
    for (int i=1;i<n;i++){
      if (i>0 && nums[i-1]==0 && nums[i]==0) return true;
      pSum[i]=pSum[i-1]+nums[i];
    } 
    for (int i =1; i<n;i++){
      for ( int j =0; j<n-i;j++ ){
        int subArraySum = pSum[i+j] - ( j-1<0?0:pSum[j-1] );
        if (subArraySum%k==0) return true;
      }
    }
    return false;
  }

  private static boolean checkSubarraySum1(int[] nums, int k) {
    int n = nums.length;
    int[] pSum = new int[n];
    Map<Integer,Integer> map = new HashMap<>();
    map.put(0, -1);
    pSum[0] = nums[0];
    for (int i=0;i<n;i++){
      if (i>0 && nums[i-1]==0 && nums[i]==0) return true;
      pSum[i]= (i>0?pSum[i-1]:0) + nums[i];
      if ( map.containsKey(pSum[i]%k)) {
        if (nums[i]==0) continue;
        return true;
      }
      else map.put( pSum[i]%k , i);
    } 
    return false;
  }
  
  private static boolean checkSubarraySum2(int[] nums, int k) {
    int n = nums.length;
    int[] pSum = new int[n];
    Map<Integer,Integer> map = new HashMap<>();
    map.put(0, -1);
    for (int i=0;i<n;i++){
      pSum[i] = (i>0?pSum[i-1]:0) + nums[i];
      int remainder = pSum[i] % k;
      if ( map.containsKey(remainder)){
        if( i - map.get(remainder) >1) return true;
      }
      else map.put( remainder, i );
    } 
    return false;
  }

  public static void main(String[] args) {
    int[] nums = {1,2,12};
    // int[] nums = {3,1,2};
    int k = 6;
    System.out.println( checkSubarraySum(nums, k) );
    System.out.println( checkSubarraySum1(nums, k) );
    System.out.println( checkSubarraySum2(nums, k) );
  }
}
