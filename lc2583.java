import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class lc2583 {

  public long kthLargestLevelSum(TreeNode root, int k) {
    PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
    Deque<TreeNode> q = new ArrayDeque<>();
    TreeNode cp = root;
    long sum = 0;
    q.add(cp);
    while (!q.isEmpty()) {
      sum = 0;
      for (int i = 0, n = q.size(); i < n; i++) {
        cp = q.pollFirst();
        sum += cp.val;
        if (cp.left != null) q.add(cp.left);
        if (cp.right != null) q.add(cp.right);
      }
      pq.add(sum);
    }
    if (pq.size() < k) return -1;
    for (int i = 0; i < k; i++) sum = pq.poll();
    return sum;
  }
}
