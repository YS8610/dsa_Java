public class lc643 {
  private static double findMaxAverage1(int[] nums, int k){
    int n = nums.length;
    double max=0;

    for (int i =0;i<=n-k;i++){
      int sum = nums[i];
      int j = i+k-1;
      while(j>i){
        sum += nums[j];
        j--;
      }
      double sumD = (double) sum;
      if (i==0) max = sumD;
      else max = max>sumD?max:sumD;
    }
    return max/k;
  }

  private static double findMaxAverage(int[] nums, int k){
    int n = nums.length;
    double max=0;
    if (n==k){
      for (int num : nums) max += num;
      return max/k;
    }
    double res = 0;
    for (int i=0;i<k;i++ ) res += nums[i];
    max = res;
    int end = k-1;
    while (end<n-1){
      res = res + nums[end+1] - nums[end-(k-1)];
      max = Math.max(max, res);
      end++;
    }
    return max/k;
  }

  public static void main(String[] args) {
    int[] nums = {9,7,3,5,6,2,0,8,1,9};
    int k = 6;

    System.out.println( findMaxAverage(nums,k) );
    System.out.println( findMaxAverage1(nums,k) );
  }
}
