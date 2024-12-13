import java.util.HashMap;
import java.util.Map;

public class lc337 {

  private static int dfs(TreeNode root, Map<TreeNode, Integer> memo) {
    if (root == null) return 0;
    if (memo.containsKey(root)) return memo.get(root);
    // if do not rob
    int notRob = dfs(root.left, memo) + dfs(root.right, memo);
    // if rob
    int rob = 0;
    if (root.left != null && root.right != null) {
      rob =
        root.val +
        dfs(root.left.left, memo) +
        dfs(root.left.right, memo) +
        dfs(root.right.left, memo) +
        dfs(root.right.right, memo);
    } else if (root.left != null) rob =
      root.val +
      dfs(root.left.left, memo) +
      dfs(root.left.right, memo); else if (root.right != null) rob =
      root.val +
      dfs(root.right.left, memo) +
      dfs(root.right.right, memo); else rob = root.val;
    memo.put(root, Math.max(notRob, rob));
    return Math.max(notRob, rob);
  }

  public int rob(TreeNode root) {
    return dfs(root, new HashMap<>());
  }
}
