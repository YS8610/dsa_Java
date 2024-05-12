public class lc540 {
  
  private static int singleNonDuplicate(int[] nums) {
    int n = nums.length;
    if (n==1) return nums[0];
    if (nums[0]!=nums[1]) return nums[0];
    if (nums[n-1]!=nums[n-2] ) return nums[n-1];
    int lp = 0;
    int rp = n-1;
    int sp;

    while ( rp-lp>1 ){
      sp = (rp+lp)/2;
      int result = nums[sp];
      if ( nums[sp-1]!= result && nums[sp+1]!=result) return nums[sp];
      if (sp%2==0) {
        if (nums[sp+1]==nums[sp]) lp = sp+1;
        else rp = sp-1;
      }
      else{
        if (nums[sp]==nums[sp-1]) lp=sp+1;
        else rp = sp-1;
      }
    }
    return nums[lp];

  }

// binary search

  public static void main(String[] args) {
    int[] nums = {3,3,2,7,7,8,10,10,11,11};
    System.out.println( singleNonDuplicate(nums) );
  }
}
