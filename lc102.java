import java.util.ArrayList;
import java.util.List;

public class lc102 {

  private static List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) return new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    List<TreeNode> nodes = new ArrayList<>(List.of(root));
    int counter = 0;
    while (!nodes.isEmpty()) {
      List<TreeNode> temp = new ArrayList<>();
      List<Integer> values = new ArrayList<>(
        (int) (Math.pow(2, ++counter) < 2000 ? Math.pow(2, ++counter) : 2000)
      );
      for (TreeNode node : nodes) {
        values.add(node.val);
        if (node.left != null) temp.add(node.left);
        if (node.right != null) temp.add(node.right);
      }
      ans.add(new ArrayList<>(values));
      nodes = temp;
    }
    return ans;
  }
}
