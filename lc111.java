import java.util.ArrayDeque;
import java.util.Queue;

public class lc111 {
  private static int minDepth(TreeNode root) {
    if (root==null) return 0;
    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);
    int ans = 0;
    while(!q.isEmpty()){
      int qlen = q.size();
      ans++;
      for (int i=qlen; i>0;i--){
        TreeNode fiq = q.remove();
        if (fiq.left==null && fiq.right==null) return ans;
        if (fiq.left!=null) q.add(fiq.left);
        if (fiq.right!=null) q.add(fiq.right);
      }
    }
    return ans;
  }
}
