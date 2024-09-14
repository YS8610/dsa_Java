import java.util.ArrayList;
import java.util.List;

public class lc590 {
  public List<Integer> postorder(Node root) {
    if (root == null) return new ArrayList<>();
    List<Integer> ans = new ArrayList<>();
    // for (Node c : root.children){
    //   ans.addAll(postorder(c));
    // }
    ans.add(root.val);
    return ans;
  }
}
