import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class lc103 {

  private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) return new ArrayList<>();
    Deque<TreeNode> q = new ArrayDeque<>();
    List<List<Integer>> ans = new ArrayList<>();
    q.add(root);
    int qlen = 1;
    boolean left = true;
    while (!q.isEmpty()) {
      LinkedList<Integer> temp = new LinkedList<>();
      if (left) {
        for (int i = 0, n = qlen; i < n; i++) {
          TreeNode top = q.pollFirst();
          temp.add(top.val);
          if (top.left != null) q.add(top.left);
          if (top.right != null) q.add(top.right);
        }
      } else {
        for (int i = 0, n = qlen; i < n; i++) {
          TreeNode top = q.pollFirst();
          temp.addFirst(top.val);
          if (top.left != null) q.add(top.left);
          if (top.right != null) q.add(top.right);
        }
      }
      ans.add(new ArrayList<>(temp));
      qlen = q.size();
      left = !left;
    }
    return ans;
  }

  public static void main(String[] args) {
    int nullSub = 0;
    List<Integer> treeNodesVal = List.of(
      3,
      9,
      20,
      nullSub,
      nullSub,
      15,
      7
    );
    List<Integer> b = new ArrayList<>();
    for (Integer val : treeNodesVal) {
      if (val != nullSub) b.add(val); else b.add(null);
    }
    TreeNode p0 = TreeNode.populate(b);
    System.out.println(zigzagLevelOrder(p0).toString());
  }
}
