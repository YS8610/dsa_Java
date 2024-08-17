import java.util.ArrayList;
import java.util.List;

public class lc145 {
  public List<Integer> postorderTraversal(TreeNode root) {
    if (root == null) return new ArrayList<>();
    List<Integer> ans = new ArrayList<>();
    ans.addAll(postorderTraversal(root.left));
    ans.addAll(postorderTraversal(root.right));
    ans.add(root.val);
    return ans;
  }
}
