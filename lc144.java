import java.util.ArrayList;
import java.util.List;

public class lc144 {
  
  private static List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>(100);
    helper(root, ans);
    return ans;
  }

  private static void helper(TreeNode root, List<Integer>ans){
    if (root==null) return;
    ans.add(root.val);
    if(root.left==null && root.right==null) return;
    if (root.left!=null) helper(root.left,ans);
    if (root.right!=null) helper(root.right, ans);
  }

}
