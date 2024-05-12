public class lc437 {
  private static int ans = 0;

  private static void bfsSum(TreeNode root, int targetSum, long sum){
    if (root == null) return;
    if (Long.compare(root.val + sum, targetSum) == 0) ans++;
    bfsSum(root.left, targetSum, root.val + sum);
    bfsSum(root.right, targetSum, root.val + sum);
  }
  
  private static void bfs(TreeNode root, int targetSum){
    if (root == null) return;
    bfsSum(root, targetSum, 0);
    bfs(root.left, targetSum);
    bfs(root.right, targetSum);
  }

  private static int pathSum(TreeNode root, int targetSum){
    bfs(root,targetSum);
    return ans;
  }
}
