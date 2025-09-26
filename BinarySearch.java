import java.util.Arrays;

public class BinarySearch {
  // exact number
  public static int exactbs(int[] nums, int k){
    int l = nums.length;
    int lp=0, rp =l;
    int mp;
    while (lp <= rp){
      mp = lp + (rp-lp)/2;
      if (nums[mp] == k)
        return mp;
      if (nums[mp] < k)
        lp = mp +1;
      else
        rp = mp -1;
    }
    return -1;
  } 


  // less than or equal 
  public static int bs(int[] nums, int k) {
    int l = nums.length;
    int lp = 0, rp = l;
    int mp;
    if (k > nums[l - 1])
      return l;
    while (lp < rp) {
      mp = lp + (rp - lp) / 2;
      if (nums[mp] == k)
        rp = mp;
      if (nums[mp] < k)
        lp = mp+1;
      else
        rp = mp;
    }
    return lp;
  }

  public static boolean can(int[] nums, int pos, int sum){
    int l = nums.length;
    if (pos == l-1){
      System.out.println(sum);
      if (sum == 24)
        return true;
      else
        return false;
    }
    return can(nums, pos+1, sum+nums[pos+1]) || 
           can(nums, pos+1, sum-nums[pos+1]) ||
           can(nums, pos+1, sum*nums[pos+1]) ||
           can(nums, pos+1, sum/nums[pos+1]);
  }

  public static void main(String[] args) {
    // int[] nums = new int[]{25,96,3,53,12,85,541};
    int[] nums = new int[]{1,12,25,53,85,96,541};
    // System.out.println(bs(nums, 5));
    // System.out.println(exactbs(nums, 25));

    int[] qn = {6,7,11,11};
    System.out.println(can(qn, 0, qn[0]));
  }
}
