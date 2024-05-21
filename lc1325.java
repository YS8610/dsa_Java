import java.util.ArrayList;
import java.util.List;

public class lc1325 {
  private static TreeNode removeLeafNodes(TreeNode root, int target) {
    if (root==null) return null;
    if (root.left==null && root.right==null && root.val==target) return null;
    if (root.left==null && root.right==null ) return root;
    root.left = removeLeafNodes(root.left, target);
    root.right = removeLeafNodes(root.right, target);
    if (root.left==null && root.right==null && root.val==target) return null;
    return root;
  }

  public static void main(String[] args) {
    int nullSub = 0;
    List<Integer> treeNodesVal= List.of(1,3,3,3,2);
    List<Integer> b = new ArrayList<>();
    for (Integer val :treeNodesVal) {
      if (val!=nullSub) b.add(val);
      else b.add(null);
    }
    TreeNode p0 = TreeNode.populate(b);
    TreeNode ans = removeLeafNodes(p0, 3);
  }
}
