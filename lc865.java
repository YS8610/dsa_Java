import java.util.ArrayDeque;
import java.util.Deque;

public class lc865 {
  public TreeNode subtreeWithAllDeepest(TreeNode root) {
    TreeNode[] par = new TreeNode[1001];
    Deque<TreeNode> q = new ArrayDeque<>();
    int height = dfs(root);
    boolean[] visit = new boolean[1001];
    q.add(root);
    TreeNode tmp;
    while (!q.isEmpty()) {
      if (--height == 0)
        break;
      for (int i = 0, n = q.size(); i < n; i++) {
        tmp = q.poll();
        if (tmp.left != null) {
          par[tmp.left.val] = tmp;
          q.add(tmp.left);
        }
        if (tmp.right != null) {
          par[tmp.right.val] = tmp;
          q.add(tmp.right);
        }
      }
    }
    while (!q.isEmpty()) {
      if (q.size() == 1)
        break;
      for (int i = 0, n = q.size(); i < n; i++) {
        tmp = q.poll();
        if (visit[par[tmp.val].val])
          continue;
        visit[par[tmp.val].val] = true;
        q.add(par[tmp.val]);
      }
    }
    return q.peek();
  }

  private static int dfs(TreeNode root) {
    if (root == null)
      return 0;
    return Math.max(dfs(root.left) + 1, dfs(root.right) + 1);
  }
}
