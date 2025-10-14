import java.util.ArrayDeque;
import java.util.Deque;

public class lc1315 {
  public int sumEvenGrandparent(TreeNode root) {
    if (root == null)
      return 0;
    int ans = 0;
    if (root.val % 2 == 0)
      ans += sum(root);
    int left = sumEvenGrandparent(root.left);
    int right = sumEvenGrandparent(root.right);
    return ans + left + right;
  }

  public int sum(TreeNode root) {
    if (root == null)
      return 0;
    TreeNode tmp;
    int ans = 0;
    Deque<TreeNode> q = new ArrayDeque<>();
    int level = 0;
    q.add(root);
    while (!q.isEmpty()) {
      level++;
      for (int i = 0, n = q.size(); i < n; i++) {
        tmp = q.poll();
        if (tmp.left != null)
          q.add(tmp.left);
        if (tmp.right != null)
          q.add(tmp.right);
      }
      if (level == 2) {
        for (int i = 0, n = q.size(); i < n; i++)
          ans += q.poll().val;
        break;
      }
    }
    return ans;
  }
}
