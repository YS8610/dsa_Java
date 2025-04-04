import java.util.ArrayDeque;
import java.util.Deque;

public class lc1123 {
  static public TreeNode lcaDeepestLeaves(TreeNode root) {
    TreeNode[] par = new TreeNode[1001];
    Deque<TreeNode> q = new ArrayDeque<>();
    int height = dfs(root);
    boolean[] visit = new boolean[1001];
    q.add(root);
    TreeNode tmp;
    while (!q.isEmpty()){
      if (--height == 0) break;
      for (int i=0, n=q.size(); i<n;i++){
        tmp = q.poll();
        if (tmp.left != null){
          par[tmp.left.val] = tmp;
          q.add(tmp.left);
        }
        if (tmp.right != null){
          par[tmp.right.val] = tmp;
          q.add(tmp.right);
        }
      }
    }
    while (!q.isEmpty()){
      if (q.size()==1) break;
      for (int i =0, n=q.size();i<n;i++){
        tmp = q.poll();
        if (visit[par[tmp.val].val]) 
          continue;
        visit[par[tmp.val].val] = true;
        q.add(par[tmp.val]);
      }
    }
    return q.peek();
  }

  private static int dfs(TreeNode root){
    if (root == null)
      return 0;
    return Math.max(dfs(root.left)+1, dfs(root.right)+1);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(0);
    TreeNode r1 = new TreeNode(1);
    TreeNode r2 = new TreeNode(3);
    root.left = r1;
    root.right = r2;
    r1.right = new TreeNode(2);
    System.out.println(lcaDeepestLeaves(root).val);
  }
}
