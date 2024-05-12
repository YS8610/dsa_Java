import java.util.ArrayList;
import java.util.List;

public class lc938 {

  private static int ans = 0;

  private static void bfs(TreeNode root, int low, int high) {
    if (root == null) return;
    if (root.val >= low && root.val <= high) ans += root.val;
    bfs(root.left, low, high);
    bfs(root.right, low, high);
  }

  private static int rangeSumBST(TreeNode root, int low, int high) {
    ans = 0;
    bfs(root, low, high);
    return ans;
  }

  public static void main(String[] args) {
    int nullSub = 0;
    List<Integer> treeNodesVal = List.of(10, 5, 15, 3, 7, nullSub, 18);
    List<Integer> b = new ArrayList<>();
    for (Integer val : treeNodesVal) {
      if (val != nullSub) b.add(val); else b.add(null);
    }
    TreeNode p0 = TreeNode.populate(b);
    int low = 7;
    int high = 15;
    System.out.println(rangeSumBST(p0, low, high));
  }
}
