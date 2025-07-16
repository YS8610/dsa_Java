public class lc3355 {
  static public boolean isZeroArray(int[] nums, int[][] queries) {
    int l = nums.length;
    int[] prefix = new int[l];
    for (int[] q : queries) {
      if (q[0] > 0)
        prefix[q[0] - 1]++;
      prefix[q[1]]--;
    }
    for (int i = l - 2; i >= 0; i--) 
      prefix[i] += prefix[i+1];
    for (int i = 0; i < l; i++) {
      if (prefix[i] + nums[i] > 0)
        return false;
    }
    return true;
  }

  public static void main(String[] args){
    int[] nums = {1,0,1};
    int[][] queries = {{0,2}};
    System.out.println(isZeroArray(nums, queries));
  }
}
