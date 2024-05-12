import java.util.Arrays;

public class lc2540 {
  
  private static int getCommon(int[] nums1, int[] nums2){
    int n1 = nums1.length;
    int n2 = nums2.length;
    int[] longer = n1>=n2?nums1:nums2;
    int[] shorter = n1>=n2?nums2:nums1;
    n1 = longer.length;
    n2 = shorter.length;
    for (int i=0,m=shorter.length;i<m;i++){
      if (shorter[i]>longer[n1-1]) break;
      int ind = Arrays.binarySearch(longer,shorter[i]);
      if (ind>=0) return shorter[i];
    }
    return -1;
  }
  public static void main(String[] args) {
    int[] nums1 = {0}, nums2 = {5};
    System.out.println( getCommon(nums1, nums2));
  }
}
