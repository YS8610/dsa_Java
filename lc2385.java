import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class lc2385 {

  private static int amountOfTime(TreeNode root, int start) {
    Deque<TreeNode> q = new ArrayDeque<>();
    Map<TreeNode, List<TreeNode>> adjMatrix = new HashMap<>();
    TreeNode temp;
    TreeNode parentNode;
    TreeNode startNode = root;
    Set<TreeNode> visited = new HashSet<>();
    int level = 0;
    if (root.left == null && root.right == null) return 0;
    q.add(root);
    while (!q.isEmpty()) {
      temp = q.pollFirst();
      List<TreeNode> neighbor = new ArrayList<>();
      if (temp.val != root.val) {
        parentNode = q.pollFirst();
        neighbor.add(parentNode);
      }
      if (temp.left != null) {
        q.add(temp.left);
        q.add(temp);
        neighbor.add(temp.left);
      }
      if (temp.right != null) {
        q.add(temp.right);
        q.add(temp);
        neighbor.add(temp.right);
      }
      if (temp.val == start) startNode = temp;
      adjMatrix.put(temp, neighbor);
    }
    q.add(startNode);
    int levelsize = 0;
    while (!q.isEmpty()) {
      levelsize = q.size();
      while (levelsize > 0) {
        temp = q.pollFirst();
        if (visited.contains(temp)) levelsize--; 
        else {
          visited.add(temp);
          for (TreeNode i : adjMatrix.get(temp)) {
            if (!visited.contains(i)) q.add(i);
          }
          levelsize--;
        }
      }
      level++;
    }
    return level - 1;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    TreeNode node5 = new TreeNode(5);
    TreeNode node3 = new TreeNode(3);
    root.left = node5;
    root.right = node3;
    TreeNode node4 = new TreeNode(4);
    node5.right = node4;
    TreeNode node9 = new TreeNode(9);
    TreeNode node2 = new TreeNode(2);
    node4.left = node9;
    node4.right = node2;
    TreeNode node10 = new TreeNode(10);
    TreeNode node6 = new TreeNode(6);
    node3.left=node10;
    node3.right=node6;
    int start = 3;
    System.out.println(amountOfTime(root, start));
  }
}
