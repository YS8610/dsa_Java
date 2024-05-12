public class lc220 {
  
  private static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff){
    int n= nums.length;
    for (int lp=0;lp<n;lp++){
      int rp = lp+indexDiff<n?lp+indexDiff:n-1;
      while (rp>lp){
        int remainder = Math.abs( nums[lp]-nums[rp] );
        if ( remainder<=valueDiff ) return true;
        rp--;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[] nums = {7,1,3};
    int indexDiff = 2, valueDiff = 3;

    System.out.println( containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff) );
  }
}
