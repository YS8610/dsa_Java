public class lc2331 {

  private static int dfs(TreeNode root){
    if (root.left==null && root.right==null){
      return root.val;
    }
    int ans = 0;
    if (root.val == 2) ans = dfs(root.left) | dfs(root.right);
    else ans = dfs(root.left) & dfs(root.right);
    return ans;
  }

  private static boolean evaluateTree(TreeNode root) {
    int ans = dfs(root);
    return ans ==1?true:false;
  }

}
