import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc101 {

  private static boolean isSymmetric(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    TreeNode temp;
    List<TreeNode> a;
    int l, lp, rp;
    if (root.left==null && root.right!=null) return false;
    if (root.right==null && root.left!=null) return false;
    q.add(root);
    while (!q.isEmpty()) {
      l = q.size();
      if (l % 2 != 0) return false;
      for (int i = 0; i < l; i++) {
        temp = q.remove();
        if (temp.left != null) q.add(temp.left);
        if (temp.right != null) q.add(temp.right);
      }
      lp = -1;
      rp = q.size();
      a = new ArrayList<>(q);
      while (++lp < --rp) {
        if (a.get(lp).val != a.get(rp).val) return false;
        if (
          (a.get(lp).left == null ? 101 : a.get(lp).left.val) !=
          (a.get(rp).right == null ? 101 : a.get(rp).right.val)
        ) return false;
        if (
          (a.get(lp).right == null ? 101 : a.get(lp).right.val) !=
          (a.get(rp).left == null ? 101 : a.get(rp).left.val)
        ) return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int nullSub = 0;
    List<Integer> treeNodesVal = List.of(1, 0);
    List<Integer> b = new ArrayList<>();
    for (Integer val : treeNodesVal) {
      if (val != nullSub) b.add(val); else b.add(null);
    }
    TreeNode p0 = TreeNode.populate(b);

    System.out.println(isSymmetric(p0));
  }
}
