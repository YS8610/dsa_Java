import java.util.Arrays;

class lc3356{
  static public int minZeroArray(int[] nums, int[][] queries) {
    int l = queries.length;
    int lp = 0;
    int rp = l;
    int guess = (rp-lp)/2+lp;
    boolean allzero = true;
    for (int n :nums)
      if (n > 0)
        allzero = false;
    if (allzero)
      return 0;
    if (!iszero2(nums, queries,l))
      return -1;
    while (rp - lp > 1){
      if (iszero2(nums, queries, guess))
          rp = guess;
      else 
          lp = guess;
      guess = (rp-lp)/2+lp;
    }
    if (iszero2(nums, queries, lp))
      return lp;
    return rp;
  }

  private static boolean iszero(int[] nums, int[][] queries, int k, int[] max, int[] memo){
    int l = nums.length;
    if (k <= max[0])
      return false;
    int[] tmp = Arrays.copyOf(memo, l);
    for (int i =max[0]; i<k;i++)
      for (int j = queries[i][0]; j<=queries[i][1];j++)
        tmp[j] = Math.max(tmp[j] - queries[i][2],0);
    for (int n:tmp)
      if (n > 0){
        if (k > max[0])
          for (int i=0; i<l;i++)
            memo[i] = tmp[i];
        max[0] = k;
        return false;
      }
    return true;
  }

  private static boolean iszero2(int[] nums, int[][] queries, int k){
    int[] diff = new int[nums.length];
    for (int i=0; i<k;i++){
      diff[queries[i][1]] -= queries[i][2];
      if (queries[i][0] != 0)
        diff[queries[i][0]-1] += queries[i][2] ;
    }
    int d=0;
    for (int i=nums.length-1;i>=0;i--){
      d += diff[i];
      if (nums[i] + d > 0)
        return false;
    }
    return true;
  }

  public static void main(String[] args){
    int[] nums = {7,6,8};
    int[][] queries = {{0,0,2},{0,1,5},{2,2,5},{0,2,4}};
    // int[][] queries = {{1,3,2},{0,2,1}};
    System.out.println(minZeroArray(nums, queries));
  }
}
