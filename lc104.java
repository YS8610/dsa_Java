import java.util.ArrayList;
import java.util.List;

public class lc104 {
  private static int maxDepth(TreeNode root){
    if (root==null) return 0;
    List<TreeNode> parents = new ArrayList<>();
    List<TreeNode> children;
    parents.add(root);
    int lvl =0;
    while(!parents.isEmpty()){
      lvl++;
      children = new ArrayList<>();
      for(TreeNode parent : parents){
        if (parent.left!=null) children.add(parent.left);
        if (parent.right!=null) children.add(parent.right);
      }
      parents = new ArrayList<>( children);
    }
    return lvl;
  }
}
