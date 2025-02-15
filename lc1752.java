import java.util.Arrays;

class lc1752{

  private static boolean check(int[] nums) {
    int l = nums.length;
    int[] copy = Arrays.copyOf(nums, l);
    Arrays.sort(copy);
    int i = l;
    while (--i >= 0)
      if (nums[i] == copy[0]){
        while (i > 0 &&  nums[i-1] == copy[0])
          i--;    
        break;
      }
    for (int j=0;j<l;j++)
      if (nums[(i++)%l] != copy[j])
        return false;  
    return true;
  }

  public static void main(String[] args){
    int[] nums = {3,4,5,1,2};
    System.out.println(check(nums));
  }
}
