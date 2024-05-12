public class lc235 {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return null;
    if (p.val<root.val && q.val>root.val) return root;
    if (q.val<root.val && p.val>root.val) return root;
    if (root.val == p.val || root.val == q.val) return root;

    if (p.val>root.val && q.val>root.val)
      return lowestCommonAncestor(root.right, p, q);
      
    if(p.val<root.val && q.val<root.val)
      return lowestCommonAncestor(root.left, p, q);

    return root;
  }
}
