class lc543 {
  public int diameterOfBinaryTree(TreeNode root) {
    // return dfs(root.left) + dfs(root.right);
    int[] m = new int[1];
    postOrder(root, m);
    return m[0];
  }

  private static int dfs(TreeNode root) {
    if (root == null)
      return 0;
    int left = dfs(root.left) + 1;
    int right = dfs(root.right) + 1;
    return Math.max(left, right);
  }

  public int postOrder(TreeNode root, int[] m) {
    if (root == null)
      return 0;
    int lHeight = postOrder(root.left, m);
    int rHeight = postOrder(root.right, m);
    int diameter = lHeight + rHeight;
    m[0] = Math.max(m[0], diameter);
    return Math.max(lHeight, rHeight) + 1;
  }
}
