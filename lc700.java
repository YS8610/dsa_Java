public class lc700 {
 
  private static TreeNode searchBST(TreeNode root, int val) {
    if (root == null) return null;
    if (root.val == val) return root;
    if (root.val > val) return searchBST(root.left, val);
    else return searchBST(root.right, val);
  }

  public static void main(String[] args) {
    TreeNode t0 = new TreeNode(4);
    TreeNode t1 = new TreeNode(2);
    TreeNode t2 = new TreeNode(7);
    TreeNode t3 = new TreeNode(1);
    TreeNode t4 = new TreeNode(3);
    t0.left = t1;
    t0.right = t2;
    t1.left = t3;
    t1.right = t4;
    System.out.println(searchBST(t0, 2).val);
  }
}
