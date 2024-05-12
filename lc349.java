import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc349 {
  private static int[] intersection(int[] nums1, int[] nums2) {
    int l1 = nums1.length;
    int l2 = nums2.length;
    Set<Integer> ans = new HashSet<>();
    Set<Integer> set = new HashSet<>();
    if (l1>=l2) {
      for (int i : nums1) set.add(i);
      for (int i : nums2) if (set.contains(i)) ans.add(i);
      return ans.stream().mapToInt(Integer::valueOf).toArray();
    }
    else{
      for (int i : nums2) set.add(i);
      for (int i : nums1) if (set.contains(i)) ans.add(i);
      return ans.stream().mapToInt(Integer::valueOf).toArray();
    }
  }

  public static void main(String[] args) {
    int[] nums1 = {1,2,2,1}, nums2 = {2,2};
    System.out.println( Arrays.toString(intersection(nums1, nums2)));
  }
}
