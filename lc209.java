public class lc209 {
  static private int minSubArrayLen1(int target, int[] nums){
    int n = nums.length;
    if(n==1) return nums[0]>=target?1:0;
    for(int i=1;i<n;i++){
      int ans =0;
      for(int j =0; j<i;j++){
        ans+=nums[j];
      }
      if (ans>=target) return i;
      for (int k=i;k<n;k++){
        ans = ans - nums[k-i]+nums[k];
        if (ans>=target) return i;
      }
    }
    int ans =0;
    for(int j =0; j<n;j++){
      ans+=nums[j];
    }
    if (ans>=target) return n;
    return 0;
  }
  static private int minSubArrayLen(int target, int[] nums){
    int n = nums.length;
    if(n==1) return nums[0]>=target?1:0;
    int lp = 0;
    int rp = 0;
    int size =n+1;
    int sum = 0;
    outloop:
    for (lp=0; lp<n;lp++){
      if (nums[lp]>=target) return 1;
      if (lp==0) sum = nums[lp];
      else sum = sum - nums[lp-1];
      if (lp==0) rp = 0;
      while( sum<target){
        if (size<=rp-lp+1) break;
        rp++;
        if(rp>n-1) {
          if (rp-lp == n && sum< target) return 0;
          continue outloop;
        } 
        sum +=nums[rp];
      }
      size = Math.min(size, rp-lp+1);

    }
    return size;
  }

  static private int minSubArrayLen2(int target, int[] nums){
    int n = nums.length;
    int ans =n+1;
    int lp =0, sum=0;
    for(int rp=0; rp<n;rp++){
      sum += nums[rp];
      while(sum>=target){
        ans=Math.min(ans, rp-lp+1);
        sum -= nums[lp++];
      }
    } 
    return ans;
  }

// dynamic sliding window
  public static void main(String[] args) {
    int target = 7;
    // int[] nums = {1,2,3,4,5};
    // int[] nums = {1,1,2,1};
    int[] nums = {2,3,1,2,4,3};
    System.out.println( minSubArrayLen1(target, nums) );
    System.out.println( minSubArrayLen(target, nums) );
    System.out.println( minSubArrayLen2(target, nums) );
  }
}
