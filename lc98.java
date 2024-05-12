import java.util.ArrayList;
import java.util.List;

public class lc98 {

  private static boolean isValidBST(TreeNode root) {
    if (root.left == null && root.right == null) return true;

    if (root.left != null && root.right != null) {
      if (
        helper(root.left, -1l+(long)Integer.MIN_VALUE , root.val) &&
        helper(root.right, root.val, 1l+(long)Integer.MAX_VALUE)
      ) return true;
      return false;
    } 
    
    else if (root.left != null && root.right == null) {
      if (helper(root.left, -1l+(long)Integer.MIN_VALUE, root.val)) return true;
      return false;
    }
    // (root.left==null && root.right!=null)
    else {
      if (helper(root.right, root.val, 1l+(long)Integer.MAX_VALUE)) return true;
      return false;
    }
  }

  private static boolean helper(TreeNode root, long start, long end) {
    if (root.val <= start || root.val >= end) return false;

    if (root.left == null && root.right == null) return true;

    if (root.left != null && root.right != null) {
      if (
        helper(root.left, start, root.val) && helper(root.right, root.val, end)
      ) return true;
      return false;
    } 
    
    else if (root.left != null && root.right == null) {
      if (helper(root.left, start, root.val)) return true;
      return false;
    }
    // if (root.left==null && root.right!=null)
    else {
      if (helper(root.right, root.val, end)) return true;
      return false;
    }
  }

  public static void main(String[] args) {
    int nullSub = -555;
    List<Integer> treeNodesVal = List.of(3, 1, 5, 0, 2, 4, 6);
    // List<Integer> treeNodesVal = List.of(120,70,140,50,100,130,160,20,55,75,110,119,135,150,200);
    // List<Integer> treeNodesVal = List.of(
    //   32,
    //   26,
    //   47,
    //   19,
    //   nullSub,
    //   nullSub,
    //   56,
    //   nullSub,
    //   27
    // );
    List<Integer> b = new ArrayList<>();
    for (Integer val : treeNodesVal) {
      if (val != nullSub) b.add(val); else b.add(null);
    }
    TreeNode p0 = TreeNode.populate(b);
    System.out.println(isValidBST(p0));
  }
}
