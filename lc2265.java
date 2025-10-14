public class lc2265 {
  public int averageOfSubtree(TreeNode root) {
    int[] m = new int[1];
    dfs(root, m);
    return m[0];
  }

  public int[] dfs(TreeNode root, int[] m) {
    if (root == null)
      return new int[] { 0, 0 };
    int[] left = dfs(root.left, m);
    int[] right = dfs(root.right, m);
    int subavg = (root.val + left[0] + right[0]) / (left[1] + right[1] + 1);
    m[0] += subavg == root.val ? 1 : 0;
    return new int[] { root.val + left[0] + right[0], left[1] + right[1] + 1 };
  }
}
