import java.util.ArrayList;
import java.util.List;

public class lc1448 {

  private static List<TreeNode> l;

  private static void dfs(TreeNode root, int max) {
    if (root == null) return;
    if (root.val >= max) {
      l.add(root);
      max = root.val;
    }
    dfs(root.left, max);
    dfs(root.right, max);
  }

  private static int goodNodes(TreeNode root) {
    l = new ArrayList<>();
    dfs(root, root.val);
    return l.size();
  }

  public static void main(String[] args) {
    int nullSub = 0;
    List<Integer> treeNodesVal = List.of(3, 1, 4, 3, nullSub, 1, 5);
    List<Integer> b = new ArrayList<>();
    for (Integer val : treeNodesVal) {
      if (val != nullSub) b.add(val); else b.add(null);
    }
    TreeNode p0 = TreeNode.populate(b);
    System.out.println(goodNodes(p0));
  }
}
