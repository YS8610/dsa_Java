import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class lc496 {
  private static int[] nextGreaterElement(int[] nums1, int[] nums2){
    List<Integer> a = Arrays.stream(nums2).boxed().collect(Collectors.toList());

    int len1 = nums1.length; 
    int len2 = nums2.length;
    int[] ans = new int [nums1.length];
    for (int i=0;i<len1;i++ ){
      int index = a.indexOf( nums1[i]);
      if (index == len2-1){
        ans[i] = -1;
        continue;
      }
      else{
        for(int j= index+1; j<len2;j++){
          if (nums2[j]> nums1[i] ){
            ans[i] = nums2[j];
            break;
          }
          ans[i] = -1;
        }
      }

    }
    return ans;
  }
  public static void main(String[] args) {
    int[] nums1 = {4,1,2}, nums2 = {1,2,3,4};
    System.out.println( Arrays.toString(nextGreaterElement(nums1, nums2))  );
  }
}
