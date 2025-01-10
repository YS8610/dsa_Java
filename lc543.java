class lc543{
    public int diameterOfBinaryTree(TreeNode root) {
        return dfs(root.left)+dfs(root.right);
    }

    private static int dfs(TreeNode root){
        if (root==null) return 0;
        int left = dfs(root.left)+1;
        int right = dfs(root.right)+1;
        return Math.max(left,right);
    }
}
