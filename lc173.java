import java.util.ArrayDeque;
import java.util.Deque;

public class lc173 {
  Deque<TreeNode> q;
  
  public lc173(TreeNode root) {
    this.q = new ArrayDeque<>();
    helper(root, q);
  }
  
  public int next() {
    return this.q.poll().val;
  }
  
  public boolean hasNext() {
    return !this.q.isEmpty();
  }

  private static void helper(TreeNode root, Deque<TreeNode> q){
    if (root==null) return;
    helper(root.left, q);
    q.add(root);
    helper(root.right, q);
  }

}
