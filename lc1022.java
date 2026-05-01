import java.util.Arrays;

public class lc1022 {
  static public int sumRootToLeaf(TreeNode root) {
    return dfs(root, 0);
  }

  static public int dfs(TreeNode root, int amt) {
    if (root == null)
      return 0;
    if (root.left == null && root.right == null)
      return (amt << 1) + root.val;
    amt = (amt << 1) + root.val;
    return dfs(root.left, amt) + dfs(root.right, amt);
  }

  public static void main(String[] args) {
    TreeNode root = TreeNode.populate(Arrays.asList(1, 1, 1));
    System.out.println(sumRootToLeaf(root));
  }
}
