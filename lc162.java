import java.util.Comparator;
import java.util.PriorityQueue;

public class lc162 {

  private static int findPeakElement(int[] nums) {
    int l = nums.length;
    if (l == 1) return 0;
    if (l == 2) return nums[0] > nums[1] ? 0 : 1;
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i = 0; i < l; i++) {
      if (i == 0) {
        pq.add(nums[i]);
        continue;
      }
      if (i == l - 1) {
        pq.add(nums[i]);
        if (pq.peek() == nums[i]) return i;
      }
      if (pq.peek() > nums[i]) return i - 1;
      pq.poll();
      pq.add(nums[i]);
    }
    return 0;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 1, 3, 5, 6, 4 };
    System.out.println(findPeakElement(nums));
  }
}
