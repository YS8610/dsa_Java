public class lc287 {
  private static int findDuplicate(int[] nums){
    int len = nums.length;
    int correct = 0;
    int sum=0;
    for (int i=1; i<len;i++) correct +=i;
    for (int n:nums) sum+=n;
    return sum-correct;
  }

  public static void main(String[] args) {
    int[] nums = {3,1,3,4,2};
    System.out.println( findDuplicate(nums));
  }
}
