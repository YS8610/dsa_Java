import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class lc2215{
  private static List<List<Integer>> findDifference(int[] nums1, int[] nums2){

    Set<Integer> set1 = new HashSet<>( Arrays.stream(nums1).boxed().toList() );
    Set<Integer> set2 = new HashSet<>( Arrays.stream(nums2).boxed().toList() );
    Set<Integer> s1 = new HashSet<>();
    Set<Integer> s2 = new HashSet<>();
    for (int a : nums1) if (!set2.contains(a)) s1.add(a);
    for (int b : nums2) if (!set1.contains(b)) s2.add(b);
    return List.of(s1.stream().toList(),s2.stream().toList());
  }
  public static void main(String[] args) {
    int[] nums1 = {1,2,3,3}, nums2 = {1,1,2,2};
    System.out.println( findDifference(nums1, nums2).toString() );
  }
}