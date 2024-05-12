import java.util.ArrayList;
import java.util.List;

public class lc112 {

  private static boolean hasPathSum(TreeNode root, int targetSum) {
    if (root==null) return false;
    int remainder = targetSum - root.val;
    if (root.left==null && root.right==null && remainder==0) return true;
    if (root.left!=null) if (hasPathSum(root.left, remainder)) return true;
    if (root.right!=null) if (hasPathSum(root.right, remainder)) return true;
    return false; 
  }

  public static void main(String[] args) {
    int nullSub = 0;
    List<Integer> treeNodesVal= List.of(5,4,8,11,nullSub,13,4,7,2,nullSub,nullSub,5,1);
    List<Integer> b = new ArrayList<>();
    for (Integer val :treeNodesVal) {
      if (val!=nullSub) b.add(val);
      else b.add(null);
    }
    TreeNode p0 = TreeNode.populate(b);
    int targetSum = 22;
    System.out.println( hasPathSum(p0, targetSum) );
  }

}
