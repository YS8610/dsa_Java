import java.util.Arrays;

class lc27{

  public static void main(String[] args) {
    int[] nums = new int[]{0,1,2,2,3,0,4,2};
    int val = 2;
    int k = 0;

    for (int i=0,n=nums.length;i<n;i++){
        if (nums[i] == val){
            nums[i]=101;
            k++;
        }
    }
    Arrays.sort(nums);
    System.out.println(nums.length - k);
    System.out.println(Arrays.toString(nums));

  }
}