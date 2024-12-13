import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc863 {

  public void dfs(TreeNode root, TreeNode cp, TreeNode[] map) {
    if (cp == null) return;
    map[cp.val] = root;
    dfs(cp, cp.left, map);
    dfs(cp, cp.right, map);
  }

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    TreeNode[] map = new TreeNode[500 + 1];
    map[root.val] = null;
    dfs(root, root.left, map);
    dfs(root, root.right, map);
    Queue<TreeNode> q = new LinkedList<>();
    q.add(target);
    boolean[] subans = new boolean[501];
    boolean[] visited = new boolean[501];
    TreeNode cp;
    while (!q.isEmpty() && k >= 0) {
      for (int i = 0, n = q.size(); i < n; i++) {
        cp = q.poll();
        if (cp == null || visited[cp.val]) continue;
        visited[cp.val] = true;
        if (k == 0) {
          subans[cp.val] = true;
          continue;
        }
        q.add(cp.left);
        q.add(cp.right);
        q.add(map[cp.val]);
      }
      k--;
    }
    List<Integer> ans = new ArrayList<>();
    for (int i = 0, n = subans.length; i < n; i++) if (subans[i]) ans.add(i);
    return ans;
  }
}
