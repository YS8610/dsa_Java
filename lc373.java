import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc373 {
  private static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<List<Integer>> ans1 = new ArrayList<>();
    List<List<Integer>> ans2 = new ArrayList<>();
    int len1 = nums1.length;
    int len2 = nums2.length;
    int[][] table = new int[len1][len2];
    int counter1 = 0;
    int sum1 = 0;
    outerloop1:
    for (int i=0;i<len1;i++){
      for (int j=0; j<len2;j++){
        table[i][j] = nums1[i] + nums2[j];
        ans1.add(new ArrayList<>(Arrays.asList(nums1[i],nums2[j])) );
        sum1 += table[i][j];
        counter1++;
        if (counter1 >=k) break outerloop1;
      }
    }
    int counter2 = 0;
    int sum2 = 0;
    outerloop2:
    for (int j=0;j<len2;j++){
      for (int i=0; i<len1;i++){
        table[i][j] = nums1[i] + nums2[j];
        ans2.add(new ArrayList<>(Arrays.asList(nums1[i],nums2[j])) );
        sum2 +=table[i][j];
        counter2++;
        if (counter2 >=k) break outerloop2;
      }
    }
    if (sum1>sum2) return ans2;
    else return ans1;
  }


  public static void main(String[] args) {
    int[] nums1 = {1,2,4,5,6};
    int[] nums2 = {3,5,7,9};
    int k = 3;

    System.out.println( kSmallestPairs(nums1,nums2,k).toString() );
  
  }
}
