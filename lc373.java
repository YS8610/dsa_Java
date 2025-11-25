import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class lc373 {
  static public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<List<Integer>> ans = new ArrayList<>(k);
    PriorityQueue<int[]> pq = new PriorityQueue<>((m1, m2) -> Integer.compare(m1[0], m2[0]));
    Set<List<Integer>> visited = new HashSet<>();
    int l1 = nums1.length;
    int l2 = nums2.length;
    int[] top;
    int n1, n2;
    n1 = nums1[0];
    n2 = nums2[0];
    pq.add(new int[] { n1 + n2, 0, 0 });
    visited.add(List.of(0, 0));
    while (!pq.isEmpty() && k > 0) {
      top = pq.poll();
      n1 = nums1[top[1]];
      n2 = nums2[top[2]];
      ans.add(List.of(n1, n2));
      k--;
      if (top[1] + 1 < l1 && top[2] < l2 && !visited.contains(List.of(top[1] + 1, top[2]))) {
        visited.add(List.of(top[1] + 1, top[2]));
        pq.add(new int[] { nums1[top[1] + 1] + nums2[top[2]], top[1] + 1, top[2] });
      }
      if (top[1] < l1 && top[2] + 1 < l2 && !visited.contains(List.of(top[1], top[2] + 1))) {
        visited.add(List.of(top[1], top[2] + 1));
        pq.add(new int[] { nums1[top[1]] + nums2[top[2] + 1], top[1], top[2] + 1 });
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums1 = { 1, 2, 4, 5, 6 };
    int[] nums2 = { 3, 5, 7, 9 };
    int k = 3;
    System.out.println(kSmallestPairs(nums1, nums2, k).toString());
  }
}
