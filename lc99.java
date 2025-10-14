import java.util.Arrays;

public class lc99 {
  public void recoverTree(TreeNode root) {
    int[] pos = new int[1];
    int l = nodeNo(root);
    int[] tmp = new int[l];
    dfs(root, tmp, pos, true);
    pos[0] = 0;
    Arrays.sort(tmp);
    dfs(root, tmp, pos, false);
  }

  public void dfs(TreeNode root, int[] tmp, int[] pos, boolean read) {
    if (root == null)
      return;
    dfs(root.left, tmp, pos, read);
    if (read)
      tmp[pos[0]++] = root.val;
    else
      root.val = tmp[pos[0]++];
    dfs(root.right, tmp, pos, read);
  }

  public int nodeNo(TreeNode root) {
    if (root == null)
      return 0;
    int left = nodeNo(root.left);
    int right = nodeNo(root.right);
    return left + right + 1;
  }
}
