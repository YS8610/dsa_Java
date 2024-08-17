import java.util.ArrayList;
import java.util.List;

public class lc1038 {
  private static void inordertravel(TreeNode root, List<Integer> l){
    if (root == null) return;
    inordertravel(root.right, l);
    if (l.isEmpty()) l.add(root.val);
    else {
      l.set(0, l.get(0)+root.val);
      root.val = l.get(0);
    }
    inordertravel(root.left, l);
  }



  public TreeNode bstToGst(TreeNode root) {
    inordertravel(root, new ArrayList<>());
    return root;
  }
}
