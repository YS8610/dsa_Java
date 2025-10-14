public class lc687 {
  public int longestUnivaluePath(TreeNode root) {
    int[] a = new int[1];
    dfs(root, a);
    return a[0];
  }

  public int dfs(TreeNode root, int[] a) {
    if (root == null)
      return 0;
    int left = dfs(root.left, a);
    int right = dfs(root.right, a);
    int lpath = 0;
    int rpath = 0;
    if (root.left != null && root.left.val == root.val)
      lpath = left + 1;
    if (root.right != null && root.right.val == root.val)
      rpath = right + 1;
    a[0] = Math.max(a[0], lpath + rpath);
    return Math.max(lpath, rpath);
  }
}
