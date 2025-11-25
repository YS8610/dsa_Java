import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class lc199 {

  public List<Integer> rightSideView(TreeNode root) {
    if (root==null) return new ArrayList<>();
    TreeNode cp = root;
    List<Integer> ans = new ArrayList<>();
    Deque<TreeNode> q = new ArrayDeque<>();
    int qlen;
    q.add(cp);
    while (!q.isEmpty()){
      qlen = q.size();
      for (int i =0;i<qlen;i++) {
        cp = q.pollFirst();
        if (cp.left!=null) q.add(cp.left);
        if (cp.right!=null) q.add(cp.right);
        if (i==qlen-1) ans.add(cp.val);
      }
    }
    return ans;
  }

}
