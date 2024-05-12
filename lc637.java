import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class lc637 {

  private static List<Double> averageOfLevels(TreeNode root) {
    if (root == null) return new ArrayList<>();
    List<Double> ans = new ArrayList<>();
    Queue<TreeNode> nodes = new ArrayDeque<>(List.of(root));
    while (!nodes.isEmpty()) {
      double sum = 0;
      int qlen = nodes.size();
      for (int i = qlen; i > 0; i--) {
        TreeNode node = nodes.poll();
        sum += (double) node.val;
        if (node.left != null) nodes.add(node.left);
        if (node.right != null) nodes.add(node.right);
      }
      ans.add(sum / qlen);
    }
    return ans;
  }

  public static void main(String[] args) {
    int nullSub = 0;
    List<Integer> treeNodesVal = List.of(
      543, 384,652, nullSub, 445, nullSub, 699
    );
    List<Integer> b = new ArrayList<>();
    for (Integer val : treeNodesVal) {
      if (val != nullSub) b.add(val); else b.add(null);
    }
    TreeNode p0 = TreeNode.populate(b);
    System.out.println( averageOfLevels(p0).toString() );
  
  }

}
