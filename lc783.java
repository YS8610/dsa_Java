import java.util.ArrayList;
import java.util.List;

public class lc783 {
  public int minDiffInBST(TreeNode root) {
    List<Integer> list = new ArrayList<>(100);
    int ans = Integer.MAX_VALUE;
    dfs(root, list);
    // System.out.println(list.toString());
    for (int i = 0, n = list.size() - 1; i < n; i++)
      ans = Math.min(ans, list.get(i + 1) - list.get(i));
    return ans;
  }

  public static void dfs(TreeNode root, List<Integer> list) {
    if (root == null)
      return;
    dfs(root.left, list);
    list.add(root.val);
    dfs(root.right, list);
  }
}
