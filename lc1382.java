import java.util.ArrayList;
import java.util.List;

public class lc1382 {
  public TreeNode balanceBST(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    dfs(root, list);
    return build(list, 0, list.size());
  }

  // start inclusive, end exclusive
  public TreeNode build(List<Integer> list, int start, int end) {
    if (end - start == 1) {
      TreeNode root = new TreeNode(list.get(start + (end - start) / 2));
      return root;
    }
    if (end - start == 0)
      return null;
    int mid = start + (end - start) / 2;
    TreeNode root = new TreeNode(list.get(mid));
    root.left = build(list, start, mid);
    root.right = build(list, mid + 1, end);
    return root;
  }

  public void dfs(TreeNode root, List<Integer> list) {
    if (root == null)
      return;
    dfs(root.left, list);
    list.add(root.val);
    dfs(root.right, list);
  }
}
