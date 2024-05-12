import java.util.ArrayDeque;
import java.util.Deque;

public class lc513 {
  private static int findBottomLeftValue(TreeNode root) {
    TreeNode cp = root;
    Deque<TreeNode> q = new ArrayDeque<>();
    int ans=0;
    q.add(cp);
    while(!q.isEmpty()){
      for (int i=0,n=q.size();i<n;i++){
        cp = q.pollFirst();
        if (i==0) ans = cp.val;
        if (cp.left!=null) q.add(cp.left);
        if (cp.right!=null) q.add(cp.right);
      }
    }
    return ans;
  }
}
