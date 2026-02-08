public class lc1339 {
  final static int MOD = 1000000007;

  public int maxProduct(TreeNode root) {
    long[] ans = new long[1];
    int total = dfssum(root);
    dfsPo(root, total, ans);
    return (int) (ans[0] % MOD);
  }

  private int dfssum(TreeNode root) {
    if (root == null)
      return 0;
    return root.val + dfssum(root.left) + dfssum(root.right);
  }

  private int dfsPo(TreeNode root, int total, long[] ans) {
    if (root == null)
      return 0;
    int left = dfsPo(root.left, total, ans);
    int right = dfsPo(root.right, total, ans);
    // break left branch
    if (left != 0)
      ans[0] = Math.max(ans[0], (1l * left * (total - left)));
    // break right branch
    if (right != 0)
      ans[0] = Math.max(ans[0], (1l * right * (total - right)));
    return root.val + left + right;
  }
}
