import java.util.HashMap;
import java.util.Map;

public class lc124 {

  private static int maxval(TreeNode root, Map<TreeNode, Integer> memo) {
    if (root.left == null && root.right == null) return root.val;
    if (memo.containsKey(root)) return memo.get(root);
    int ans = 0;
    if (root.left != null && root.right != null) ans =
      root.val +
      Math.max(maxval(root.left, memo), maxval(root.right, memo)); else if (
      root.left == null
    ) ans = root.val + maxval(root.right, memo); else if (
      root.right == null
    ) ans = root.val + maxval(root.left, memo); else ans = root.val;
    memo.put(root, ans);
    return ans;
  }

  private static int dfs(TreeNode root, Map<TreeNode, Integer> memo) {
    if (root.left == null && root.right == null) return root.val;
    int ans = 0;
    if (root.left != null && root.right != null) {
      ans = maxval(root.left, memo) + maxval(root.right, memo) + root.val;
      ans =
        Math.max(ans, Math.max(dfs(root.left, memo), dfs(root.right, memo)));
    } else if (root.left == null) {
      ans = root.val + maxval(root.right, memo);
      ans = Math.max(ans, dfs(root.right, memo));
    } else if (root.right == null) {
      ans = root.val + maxval(root.left, memo);
      ans = Math.max(ans, dfs(root.left, memo));
    } else ans = root.val;

    return ans;
  }

  public int maxPathSum(TreeNode root) {
    if (root.left == null && root.right == null) return root.val;
    Map<TreeNode, Integer> memo = new HashMap<>();
    return dfs(root, memo);
  }
}
