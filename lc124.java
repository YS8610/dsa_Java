
public class lc124 {
  public int maxPathSum(TreeNode root) {
    int[] m = new int[1];
    m[0] = Integer.MIN_VALUE;
    dfs(root, m);
    return m[0];
  }

  public int dfs(TreeNode root, int[] m) {
    if (root == null)
      return 0;
    int left = dfs(root.left, m);
    int right = dfs(root.right, m);
    if (left >= 0 && right >= 0) {
      m[0] = Math.max(m[0], root.val + left + right);
      return Math.max(left, right) + root.val;
    }
    if (left >= 0) {
      m[0] = Math.max(m[0], root.val + left);
      return left + root.val;
    }
    if (right >= 0) {
      m[0] = Math.max(m[0], root.val + right);
      return right + root.val;
    }
    m[0] = Math.max(m[0], root.val);
    return root.val;
  }
}
