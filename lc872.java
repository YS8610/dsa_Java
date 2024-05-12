import java.util.ArrayList;
import java.util.List;

public class lc872 {

  private static List<Integer> a;
  private static List<Integer> b;

  private static void dfs(TreeNode root, List<Integer> a) {
    if (root == null) return;
    if (root.left == null && root.right == null) a.add(root.val);
    dfs(root.left, a);
    dfs(root.right, a);
  }

  private static boolean leafSimilar(TreeNode root1, TreeNode root2) {
    a = new ArrayList<>();
    b = new ArrayList<>();
    dfs(root1, a);
    dfs(root2, b);
    return a.equals(b);
  }

  public static void main(String[] args) {
    int nullSub = 0;
    List<Integer> treeNodesVal = List.of(
      3, 5,
      1, 6,
      2, 9,
      8, nullSub,
      nullSub, 7,
      4
    );
    List<Integer> c = new ArrayList<>();
    for (Integer val : treeNodesVal) {
      if (val != nullSub) c.add(val); else c.add(null);
    }
    TreeNode p0 = TreeNode.populate(c);
    List<Integer> treeNodesVal1 = List.of(
      3, 5,
      1, 6,
      7, 4,
      2, nullSub,
      nullSub, nullSub,
      nullSub, nullSub,
      nullSub, 9,
      8
    );
    List<Integer> d = new ArrayList<>();
    for (Integer val : treeNodesVal1) {
      if (val != nullSub) d.add(val); else d.add(null);
    }
    TreeNode p1 = TreeNode.populate(d);
    System.out.println(leafSimilar(p0, p1));
  }
}
