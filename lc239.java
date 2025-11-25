import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class lc239 {

  // priority q and map
  static public int[] maxSlidingWindow(int[] nums, int k) {
    int NO = 10000;
    int[] map = new int[NO * 2 + 1];
    int l = nums.length;
    int lans = l - k + 1;
    int[] ans = new int[lans];
    PriorityQueue<Integer> pq = new PriorityQueue<>((m1, m2) -> Integer.compare(m2, m1));
    for (int i = 0; i < k; i++) {
      if (map[nums[i] + NO] == 0)
        pq.add(nums[i]);
      map[nums[i] + NO]++;
    }
    ans[0] = pq.peek();
    for (int i = 1, top = 0; i < lans; i++) {
      map[nums[i - 1] + NO]--;
      if (map[nums[i + k - 1] + NO] == 0)
        pq.add(nums[i + k - 1]);
      map[nums[i + k - 1] + NO]++;
      top = pq.peek();
      while (map[top + NO] == 0) {
        pq.poll();
        top = pq.peek();
      }
      ans[i] = top;
    }
    return ans;
  }

  // monotonic q
  static public int[] maxSlidingWindow1(int[] nums, int k) {
    if (k == 1)
      return nums;
    Deque<Integer> q = new ArrayDeque<>();
    int l = nums.length;
    int[] ans = new int[l - k + 1];
    for (int i = 0, tail = 0; i < k; i++) {
      if (q.isEmpty()) {
        q.add(nums[i]);
        continue;
      }
      tail = q.peekLast();
      while (tail < nums[i]) {
        q.pollLast();
        if (q.isEmpty())
          break;
        tail = q.peekLast();
      }
      q.add(nums[i]);
    }
    ans[0] = q.peekFirst();
    for (int i = 1, n = l - k + 1, head = 0, tail = 0; i < n; i++) {
      head = q.peekFirst();
      if (head == nums[i - 1])
        q.pollFirst();
      tail = q.peekLast();
      while (tail < nums[i + k - 1]) {
        q.pollLast();
        if (q.isEmpty())
          break;
        tail = q.peekLast();
      }
      q.add(nums[i + k - 1]);
      ans[i] = q.peekFirst();
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
    int k = 3;
    System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
  }
}
