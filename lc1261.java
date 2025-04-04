import java.util.HashSet;
import java.util.Set;

public class lc1261 {
  Set<Integer> set;
  TreeNode r;

  public lc1261(TreeNode root) {
    this.set = new HashSet<>();
    this.r = root;
    this.r.val = 0;
    this.set.add(0);
    dfs(this.set, this.r);
  }

  private static void dfs(Set<Integer> set, TreeNode r) {
    if (r == null)
      return;
    if (r.left != null) {
      r.left.val = 2 * r.val + 1;
      set.add(r.left.val);
      dfs(set, r.left);
    }
    if (r.right != null) {
      r.right.val = 2 * r.val + 2;
      set.add(r.right.val);
      dfs(set, r.right);
    }
  }

  public boolean find(int target) {
    return this.set.contains(target);
  }
}
