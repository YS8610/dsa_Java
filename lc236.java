import java.util.LinkedList;
import java.util.List;

public class lc236 {

  private static List<TreeNode> dfs(
    TreeNode root,
    TreeNode p,
    LinkedList<TreeNode> a
  ) {
    if (root == null) return new LinkedList<>();
    if (root.val == p.val) {
      if (a.isEmpty()) a.addLast(p);
      return a;
    }
    if (!dfs(root.left, p, a).isEmpty()) {
      if (root.left.val != p.val) a.addFirst(root.left);
    } else if (!dfs(root.right, p, a).isEmpty()) {
      if (root.right.val != p.val) a.addFirst(root.right);
    }
    return a;
  }

  private static TreeNode lowestCommonAncestor(
    TreeNode root,
    TreeNode p,
    TreeNode q
  ) {
    LinkedList<TreeNode> a = new LinkedList<>();
    LinkedList<TreeNode> b = new LinkedList<>();
    dfs(root, p, a);
    a.addFirst(root);
    dfs(root, q, b);
    b.addFirst(root);
    int shorter = a.size() <= b.size() ? a.size() : b.size();
    int i = -1;
    while (++i < shorter) if (a.get(i).val != b.get(i).val) break;
    return a.get(i - 1);
  }

  private static TreeNode lowestCommonAncestor1(
    TreeNode root,
    TreeNode p,
    TreeNode q
  ) {
    if (root == null) return null;
    if (root.val == p.val || root.val == q.val) return root;

    TreeNode l = lowestCommonAncestor1(root.left, p, q);
    TreeNode r = lowestCommonAncestor1(root.right, p, q);
    if (l != null && r != null) return root;
    if (l != null) return l;
    return r;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    TreeNode t1 = new TreeNode(5);
    TreeNode t2 = new TreeNode(1);
    TreeNode t3 = new TreeNode(6);
    TreeNode t4 = new TreeNode(2);
    TreeNode t5 = new TreeNode(0);
    TreeNode t6 = new TreeNode(8);
    TreeNode t7 = new TreeNode(7);
    TreeNode t8 = new TreeNode(4);

    root.left = t1;
    root.right = t2;
    t1.left = t3;
    t1.right = t4;
    t2.left = t5;
    t2.right = t6;
    t4.left = t7;
    t4.right = t8;

    System.out.println(lowestCommonAncestor(root, t1, t2).val);
    System.out.println(lowestCommonAncestor1(root, t1, t2).val);

  }
}
