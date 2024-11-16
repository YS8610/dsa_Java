public class lc951 {

  public boolean flipEquiv(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) return true;
    if (root1 == null || root2 == null) return false;
    if (root1.val != root2.val) return false;
    int c1 = (root1.left == null ? 0 : 1) + (root1.right == null ? 0 : 1);
    int c2 = (root2.left == null ? 0 : 1) + (root2.right == null ? 0 : 1);
    if (c1 != c2) return false;
    if (c1 == 0) {
      if (root1.val == root2.val) return true;
      return false;
    } else if (c1 == 2) {
      if (
        root1.left.val == root2.left.val && root1.right.val == root2.right.val
      ) return (
        flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)
      );
      TreeNode tmp = root2.right;
      root2.right = root2.left;
      root2.left = tmp;
      if (
        root1.left.val != root2.left.val || root1.right.val != root2.right.val
      ) return false;
      return (
        flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)
      );
    }
    // 1 child each
    else {
      if (root1.left != null) {
        if (
          root2.left != null && root2.left.val == root1.left.val
        ) return flipEquiv(root1.left, root2.left);
        if (root2.left != null) return false;
        if (root1.left.val != root2.right.val) return false;
        root2.left = root2.right;
        root2.right = null;
        return flipEquiv(root1.left, root2.left);
      }
      // root1 right not null
      else {
        if (
          root2.right != null && root2.right.val == root1.right.val
        ) return flipEquiv(root1.right, root2.right);
        if (root2.right != null) return false;
        if (root1.right.val != root2.left.val) return false;
        root2.right = root2.left;
        root2.left = null;
        return flipEquiv(root1.right, root2.right);
      }
    }
  }
}
