import java.util.ArrayDeque;
import java.util.Deque;

public class lc623 {
  private static TreeNode addOneRow(TreeNode root, int val, int depth){
    TreeNode cp;
    TreeNode np;
    int d = 1;
    TreeNode tmp;
    if (depth == 1){
      cp = new TreeNode(val);
      cp.left = root;
      return cp;
    }
    Deque<TreeNode> q = new ArrayDeque<>();
    q.add(root);
    while (!q.isEmpty()){
      d++;
      if (d > depth) break;
      for (int i =0, n=q.size();i<n;i++){
        tmp = q.pollFirst();
        if (d == depth){
          if (tmp.left != null){
            cp = new TreeNode(val);
            q.add(tmp.left);
            np = tmp.left;
            tmp.left = cp;
            cp.left = np;
          }
          else{
            cp = new TreeNode(val);
            tmp.left = cp;
          }
          if (tmp.right != null){
            cp = new TreeNode(val);
            q.add(tmp.right);
            np = tmp.right;
            tmp.right = cp;
            cp.right = np;
          }
          else{
            cp = new TreeNode(val);
            tmp.right = cp;
          }
          continue;
        }
        if (tmp.left != null) q.add(tmp.left);
        if (tmp.right != null) q.add(tmp.right);
      }
    }
    return root;
  }

}
