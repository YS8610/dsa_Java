public class lc2148 {
  
  private static int countElements(int[] nums) {
    int n = nums.length;
    if (n<3) return 0;
    int lowest = nums[0];
    int highest = nums[0];
    for (int num:nums){
      if (num<lowest) lowest=num;
      if (num>highest) highest = num;
    }
    if (lowest==highest) return 0;
    int countLow = 0;
    int countHigh = 0;
    for (int num:nums){
      if (lowest==num) countLow++;
      if (highest==num) countHigh++;
    }
    return n-countHigh-countLow;
  }

  public static void main(String[] args) {
    int[] nums = {11,7,2,15};
    System.out.println( countElements(nums) );
  }
}
