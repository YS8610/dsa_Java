public class lc1367 {
  private static boolean dfs(TreeNode root, ListNode head){
    if (head == null) return true;
    if (root == null) return false;
    if (root.val != head.val) return false;
    return dfs(root.left, head.next) || dfs(root.right, head.next);
  }
  
  public boolean isSubPath(ListNode head, TreeNode root) {
    if (root == null) return false;
    boolean result = dfs(root, head);
    if (result) return true;
    return isSubPath(head, root.left) || isSubPath(head, root.right);
  }
}
