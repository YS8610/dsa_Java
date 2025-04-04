import java.util.Arrays;

class lc2460{
  private static int[] applyOperations(int[] nums) {
    int l = nums.length;
    for (int i=0, n=l-1; i<n;i++){
      if (nums[i] != nums[i+1])
        continue;
      nums[i] *=2;
      nums[i+1] = 0;
    }
    int[] ans = new int[l];
    int j = 0;
    for (int i=0;i<l;i++){
      if (nums[i] == 0)
        continue;
      ans[j++] = nums[i];    
    }
    return ans;
  }

  public static void main(String[] args){
    int[] nums = {1,2,2,1,1,0};
    System.out.println(Arrays.toString(applyOperations(nums)));
  }

}
