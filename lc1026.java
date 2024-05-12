import java.util.ArrayList;
import java.util.List;

public class lc1026 {

  private static List<Integer> l;

  private static void dfs(TreeNode root, int low, int high) {
    if (root == null) return;
    if (root.left == null && root.right == null) {
      l.add(Math.max(Math.abs(low - root.val), Math.abs(high - root.val)));
      return;
    }
    l.add(Math.max(Math.abs(low - root.val), Math.abs(high - root.val)));
    low = Math.min(low, root.val);
    high = Math.max(high, root.val);
    if (root.left != null) dfs(root.left, low, high);
    if (root.right != null) dfs(root.right, low, high);
  }

  private static int maxAncestorDiff(TreeNode root) {
    l = new ArrayList<>();
    dfs(root, root.val, root.val);
    int ans = l.get(0);
    for (int i : l) ans = Math.max(ans, i);
    return ans;
  }

  public static void main(String[] args) {
    int nullSub = 0;
    List<Integer> treeNodesVal = List.of(
      1,nullSub,2,nullSub,0,3
    );
    List<Integer> b = new ArrayList<>();
    for (Integer val : treeNodesVal) {
      if (val != nullSub) b.add(val); else b.add(null);
    }
    TreeNode p0 = TreeNode.populate(b);
    System.out.println(maxAncestorDiff(p0));
  }
}
