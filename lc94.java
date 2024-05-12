import java.util.ArrayList;
import java.util.List;

public class lc94 {

  private static List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) return new ArrayList<>();

    List<Integer> result = inorderTraversal(root.left);
    if (result != null) result.add(root.val);
    List<Integer> result1 = inorderTraversal(root.right);
    result.addAll(result1);
    
    return result;
  }
}
