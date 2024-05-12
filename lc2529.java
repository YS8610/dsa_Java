import java.util.Arrays;

public class lc2529 {
  
  private static int maximumCount(int[] nums){
    int n = nums.length;
    if (nums[0]>0 || nums[n-1]<0) return n;
    if (nums[0]==0 && nums[n-1]==0) return 0;
    if (n==1 && nums[0]!=0) return 1;
    if (n==1 && nums[0]==0) return 0;

    // when zero is present
    int index0 = Arrays.binarySearch(nums, 0);
    if (index0>=0){
      int lp = index0;
      int rp = index0;
      while (lp>0 && nums[lp]==0){
        int indL = Arrays.binarySearch(nums, 0, lp, 0);
        if (indL>=0) lp=indL;
        else break;
      }
      while (rp<n && nums[rp]==0){
        int indH = Arrays.binarySearch(nums, rp+1, n, 0);
        if (indH>=0) rp=indH;
        else break;
      }
      return Math.max(lp, n-rp-1);
    }
    // zero is not present
    else{
      int floor = 0;
      int ceil = n-1;
      int ind = (ceil-floor)/2;
      while( (nums[ind]<0 && nums[ind+1]<0) || ( nums[ind]>0 && nums[ind-1]>0 ) ){
        if (nums[ind]>0) ceil = ind-1;
        else floor = ind+1;
        ind = (ceil-floor)/2 + floor;
      }
      if (nums[ind]>0) return Math.max(ind, n-ind );
      if (nums[ind]<0) return Math.max(ind+1, n-1-ind);
    }
    return 0;
  }

  public static void main(String[] args) {
    int[] nums ={-925,-170,-5,728,795,810,821,919,1776,1861};
    System.out.println( maximumCount(nums) );

  }
}
