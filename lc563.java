public class lc563 {
  public int findTilt(TreeNode root) {
    int[] m = new int[1];
    postOrder(root, m);
    return m[0];
  }

  public int postOrder(TreeNode root, int[] m) {
    if (root == null)
      return 0;
    int left = postOrder(root.left, m);
    int right = postOrder(root.right, m);
    int diff = Math.abs(left - right);
    m[0] += diff;
    return left + right + root.val;
  }
}
