import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class lc1302 {
  private static int deepestLeavesSum(TreeNode root) {
    List<Integer> memo = new ArrayList<>(1001);
    Deque<TreeNode> q = new ArrayDeque<>();
    TreeNode cp = root;
    TreeNode top;
    int len=1;
    q.add(cp);
    while (!q.isEmpty()){
      len = q.size();
      for (int i=0;i<len;i++){
        top = q.pollFirst();
        memo.add(top.val);
        if (top.left!=null) q.add(top.left);
        if (top.right!=null) q.add(top.right);
      }
    }
    int ans =0;
    int n = memo.size();
    for (int i=n-len;i<n;i++) ans += memo.get(i);
    return ans;
  }

}
