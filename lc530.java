import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class lc530 {
  private static int getMinimumDifference(TreeNode root) {
    if (root==null) return 0;
    Deque<TreeNode> stack = new ArrayDeque<>();
    List<Integer> list = new ArrayList<>();
    TreeNode cp = root;

    stack.add(cp);
    while(!stack.isEmpty()){
      TreeNode top = stack.pop();
      list.add(top.val);
      if (top.left!=null){
        // int diff = top.val - top.left.val;
        // min = diff<=min?diff:min;
        stack.add(top.left);

      }
      if (top.right!=null){
        // int diff = top.right.val - top.val;
        // min = diff<=min?diff:min;
        stack.add(top.right);
      }
    }
    list.sort((m1,m2) -> m1.compareTo(m2) );
    int diff = list.get(1) - list.get(0);
    int min = diff;
    for (int i=1,n=list.size();i<n-1;i++){
      diff = list.get(i+1)-diff - list.get(i-1);
      min = diff<=min?diff:min;
    }

    return min;
  }

  // tree
  public static void main(String[] args) {
    // 543,384,652,null,445,null,699
    int nullSub = 0;
    List<Integer> treeNodesVal= List.of(543,384,652,nullSub,445,nullSub,699);
    List<Integer> b = new ArrayList<>();
    for (Integer val :treeNodesVal) {
      if (val!=nullSub) b.add(val);
      else b.add(null);
    }
    TreeNode p0 = TreeNode.populate(b);
    System.out.println( getMinimumDifference(p0) );
  }
}
