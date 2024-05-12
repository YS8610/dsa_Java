import java.util.ArrayDeque;
import java.util.Deque;

public class lc114 {

  private static void flatten(TreeNode root) {
    if (root == null) return;
    if (root.left == null && root.right == null) return;
    Deque<TreeNode> memo = new ArrayDeque<>();
    helper(root, memo);
    TreeNode cp = memo.pollFirst();
    while (!memo.isEmpty()) {
      TreeNode top = memo.pollFirst();
      cp.left = null;
      cp.right = top;
      cp = cp.right;
    }
  }

  private static void helper(TreeNode root, Deque<TreeNode> memo) {
    memo.addLast(root);
    if (root.left != null) helper(root.left, memo);
    if (root.right != null) helper(root.right, memo);
  }
}
