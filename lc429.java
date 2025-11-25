import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class lc429 {
  public List<List<Integer>> levelOrder(Node3 root) {
    if (root==null) return new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    ans.add(List.of(root.val));
    Node3 cp = root;
    List<Integer> subAns;
    Deque<Node3> q = new ArrayDeque<>();
    q.add(cp);
    while (!q.isEmpty()){
      subAns = new ArrayList<>();
      for (int i=0,n=q.size();i<n;i++){
        cp = q.pollFirst();
        if (!cp.children.isEmpty()){
          for (Node3 node : cp.children){
            subAns.add(node.val);
            q.add(node);
          }
        }
      }
      if (!subAns.isEmpty()) ans.add(subAns);
    }
    return ans;
  }
}
