import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class lc2641 {

  public TreeNode replaceValueInTree(TreeNode root) {
    TreeNode cp = root;
    Deque<TreeNode> q = new ArrayDeque<>();
    int sum = 0;
    int lvl = 0;
    List<Integer> map = new ArrayList<>();
    q.add(cp);
    while (!q.isEmpty()) {
      sum = 0;
      for (int i = 0, n = q.size(); i < n; i++) {
        cp = q.pollFirst();
        sum += cp.val;
        if (cp.left != null) q.add(cp.left);
        if (cp.right != null) q.add(cp.right);
      }
      map.add(sum);
    }
    cp = root;
    q.add(cp);
    while (!q.isEmpty()) {
      for (int i = 0, n = q.size(); i < n; i++) {
        cp = q.pollFirst();
        if (n == 1) {
          cp.val = 0;
          if (cp.left != null) {
            cp.left.val = 0;
            q.add(cp.left);
          }
          if (cp.right != null) {
            cp.right.val = 0;
            q.add(cp.right);
          }
          continue;
        }
        sum =
          (cp.left == null ? 0 : cp.left.val) +
          (cp.right == null ? 0 : cp.right.val);
        if (cp.left != null) {
          q.add(cp.left);
          if (lvl + 1 < map.size()) cp.left.val = map.get(lvl + 1) - sum;
        }
        if (cp.right != null) {
          q.add(cp.right);
          if (lvl + 1 < map.size()) cp.right.val = map.get(lvl + 1) - sum;
        }
      }
      lvl++;
    }
    return root;
  }
}
