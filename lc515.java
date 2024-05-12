import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class lc515 {
  
  private static List<Integer> largestValues(TreeNode root){
    if (root==null) return new ArrayList<>();
    List<Integer> ans = new ArrayList<>(1000);
    int largest;
    Deque<TreeNode> q = new ArrayDeque<TreeNode>();
    TreeNode top;
    q.add(root);
    while(!q.isEmpty()){
      largest = q.peek().val;
      for(int i=0,n=q.size();i<n;i++){
        top = q.pollFirst();
        largest = Math.max(largest, top.val);
        if (top.left!=null) q.add(top.left);
        if (top.right!=null) q.add(top.right);
      }
      ans.add(largest);
    }
    return ans;
  }

  public static void main(String[] args) {
    int nullSub = 55;
    List<Integer> treeNodesVal= List.of(0,-1);
    List<Integer> b = new ArrayList<>();
    for (Integer val :treeNodesVal) {
      if (val!=nullSub) b.add(val);
      else b.add(null);
    }
    TreeNode p0 = TreeNode.populate(b);
    System.out.println( largestValues(p0).toString() );
  }
}
