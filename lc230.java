import java.util.ArrayList;
import java.util.List;

public class lc230 {
  private static List<Integer> l;
  private static void dfs(TreeNode root){
      while (root==null) return;
      dfs(root.left);
      l.add(root.val);
      dfs(root.right);
  }
  private static int kthSmallest(TreeNode root, int k) {
      l = new ArrayList<>();
      dfs(root);
      // l.sort((m1,m2)->Integer.compare(m1,m2));
      return l.get(k-1);
  }

  public static void main(String[] args) {
    int nullSub = 0;
    List<Integer> treeNodesVal= List.of(5,3,6,2,4,nullSub,nullSub,1);
    List<Integer> b = new ArrayList<>();
    for (Integer val :treeNodesVal) {
      if (val!=nullSub) b.add(val);
      else b.add(null);
    }
    TreeNode p0 = TreeNode.populate(b);
    int k = 3;
    System.out.println(kthSmallest(p0, k));
  }
}
