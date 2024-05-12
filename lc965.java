public class lc965 {
  private static boolean isUnivalTree(TreeNode root) {
    if (root==null) return true;
    if (root.left==null && root.right==null) return true;
    int v = root.val;
    return helper(root, v);

  }
  private static boolean helper(TreeNode root, int v){
    if (root.val!=v) return false;
    if (root.left==null && root.right==null ) return true;

    if (root.left!=null && root.right!=null){
      if (helper(root.left, v) && helper(root.right, v)) return true;
      return false;
    }
    else if ( root.left!=null && root.right==null){
      if (helper(root.left, v)) return true;
      return false;
    }
    else{
      if (helper(root.right, v)) return true;
      return false;
    }
  }

}
