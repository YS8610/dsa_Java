class lc16{
  private static int threeSumClosest(int[] nums, int target) {
    return dfs(nums, target, 0, 3, 0);
  }

  private static int dfs(int[] nums, int target, int idx, int lvl, int sum){
    int l = nums.length;
    if (lvl <=0)
    return sum;
    int ans = nums[0] + nums[1] + nums[2];
    int tmp;
    for (int i=idx, n=l-lvl;i<=n;i++){
      tmp = dfs(nums, target, i+1, lvl-1, sum+nums[i]);
      ans = closest(ans, tmp, target);
    }
    return ans;
  }

  private static int closest(int t1, int t2, int target){
    if (Math.abs(t1 - target) <= Math.abs(t2 - target)) return t1;
    return t2;
  }

  public static void main(String[] args) {
    int[] nums = {-1,2,1,-4};
    int target = 1;
    System.out.println(threeSumClosest(nums, target));
  }
}