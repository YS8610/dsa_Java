import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class lc133 {

  private static Node cloneGraph(Node node) {
    if (node == null) return null;
    if (node.neighbors.isEmpty()) return new Node(node.val, new ArrayList<>());
    Map<Integer, List<Integer>> memo = new HashMap<>();
    Map<Integer, Node> memo1 = new HashMap<>();
    Queue<Node> q = new ArrayDeque<>();
    q.add(node);
    while (!q.isEmpty()) {
      Node tempNode = q.poll();
      if (!memo.containsKey(tempNode.val)) {
        List<Integer> temp = new ArrayList<>();
        for (Node no : tempNode.neighbors) {
          temp.add(no.val);
          q.add(no);
        }
        memo.put(tempNode.val, new ArrayList<>(temp));
        memo1.put(tempNode.val, new Node(tempNode.val));
      }
    }
    for (int key : memo.keySet()) {
      Node n = memo1.get(key);
      for (int i : memo.get(key)) n.neighbors.add(memo1.get(i));
    }
    return memo1.get(1);
  }
}
