import java.util.ArrayList;
import java.util.List;

public class lc226 {
  private static TreeNode invertTree(TreeNode root) {
    if (root==null) return null;
    helper(root);
    return root;
  }

  private static void helper(TreeNode root){
    if (root.left==null && root.right==null) return;

    if (root.left!=null && root.right!=null){
      TreeNode temp = root.left;
      root.left = root.right;
      root.right = temp;
      helper(root.left);
      helper(root.right);
    }
    
    else if (root.left==null && root.right!=null){
      root.left = root.right;
      root.right = null;
      helper(root.left);
    }
    
    else if (root.left!=null && root.right==null){
      root.right = root.left;
      root.left = null;
      helper(root.right);
    }
  }

  public static void main(String[] args) {
    int nullSub = 0;
    List<Integer> treeNodesVal= List.of(4,2,7,1,3,6,nullSub,nullSub,5,8,nullSub,nullSub,5);
    List<Integer> b = new ArrayList<>();
    for (Integer val :treeNodesVal) {
      if (val!=nullSub) b.add(val);
      else b.add(null);
    }
    TreeNode p0 = TreeNode.populate(b);
    invertTree(p0);
  }
}
