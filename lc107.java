import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc107 {

  List<List<Integer>> levelOrderBottom(TreeNode root) {
    if (root == null) return new ArrayList<>();
    LinkedList<List<Integer>> ans = new LinkedList<>();
    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);
    while (!q.isEmpty()) {
      int qlen = q.size();
      List<Integer> temp = new ArrayList<>();
      for (int i = qlen; i > 0; i--) {
        TreeNode fiq = q.remove();
        temp.add(fiq.val);
        if (fiq.left != null) q.add(fiq.left);
        if (fiq.right != null) q.add(fiq.right);
      }
      ans.addFirst(new ArrayList<>(temp));
    }
    return ans;
  }
}
