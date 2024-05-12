import java.util.ArrayList;
import java.util.List;

public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }

  public static TreeNode populate(List<Integer> list){
    List<TreeNode> trees = new ArrayList<>(list.size());
    for (int i =0,n=list.size();i<n;i++){
      if( list.get(i)!=null ) trees.add(i, new TreeNode(list.get(i)) );
      else trees.add(null);

    }
    for (int i =0,n=list.size();i<n;i++){
      if (trees.get(i)!=null && 2*i+1<n && trees.get(2*i+1)!=null ) {
        trees.get(i).left = trees.get(2*i+1);
      }
      if (trees.get(i)!=null && 2*i+2<n && trees.get(2*i+2)!=null) {
        trees.get(i).right = trees.get(2*i+2);
      }
    }
    return trees.get(0);
  }
}

// int nullSub = 0;
// List<Integer> treeNodesVal= List.of(543,384,652,nullSub,445,nullSub,699);
// List<Integer> b = new ArrayList<>();
// for (Integer val :treeNodesVal) {
//   if (val!=nullSub) b.add(val);
//   else b.add(null);
// }
// TreeNode p0 = TreeNode.populate(b);

