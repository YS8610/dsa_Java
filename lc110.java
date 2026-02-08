public class lc110 {
  public boolean isBalanced(TreeNode root) {
    boolean[] ans = new boolean[1];
    ans[0] = true;
    depth(root, ans);
    return ans[0];
  }

  private int depth(TreeNode root, boolean[] ans) {
    if (root == null)
      return 0;
    if (!ans[0])
      return 0;
    int ldepth = depth(root.left, ans);
    int rdepth = depth(root.right, ans);
    int diff = Math.abs(ldepth - rdepth);
    if (diff > 1)
      ans[0] = false;
    return Math.max(ldepth, rdepth) + 1;
  }
}
