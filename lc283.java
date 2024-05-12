import java.util.Arrays;

public class lc283 {
  
  private static void moveZeroes(int[] nums){
    int n= nums.length;
    int counter0 =0;
    int counter1 =0;

    for (int i =0; i<n;i++){
      if (nums[i]!=0){
        nums[counter1] = nums[i];
        counter1 ++;
      }
      else{
        counter0 ++;
      }
    }
    for (int j = n- counter0; j<n;j++){
      nums[j] = 0;
    }
  }
  
  
  private static void moveZeroes1(int[] nums){
    int n = nums.length;
    int zeroP = n-1;
    outloop:
    for (int i=0;i<n;i++){
      if (nums[i]==0){
        if (i == zeroP) break outloop;
        while(nums[zeroP]==0){
          zeroP--;
        }
        swap(nums, i, zeroP);
      }
    }
  }
  
  private static void swap(int[] a, int i, int j){
    if (i==j) return;
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }

  public static void main(String[] args) {
    int[] nums = {0,1,0,3,12};
    moveZeroes(nums);
    System.out.println( Arrays.toString(nums) );
  }
}
