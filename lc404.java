import java.util.ArrayList;
import java.util.List;

public class lc404 {
  private static int sumOfLeftLeaves(TreeNode root){
    if (root==null) return 0;
    List<Integer> ansList = new ArrayList<>();
    if (root.left!=null) helper(root.left, ansList, true);
    if (root.right!=null) helper(root.right, ansList, false);

    return ansList.stream().mapToInt(Integer::valueOf).sum();
  }

  private static void helper(TreeNode root, List<Integer> list, boolean isL ){
    if (root.left==null && root.right==null && isL) {
      list.add(root.val);
    }
    if (root.left!=null) helper(root.left, list, true);
    if (root.right!=null) helper(root.right, list, false);
  }

  private static int sumOfLeftLeaves1(TreeNode root){
    if (root == null) return 0;
    int ans = 0;
    if (root.left != null){
      if (root.left.left== null && root.left.right==null)
        ans += root.left.val;
      else
        ans += sumOfLeftLeaves1(root.left);
    }
    ans += sumOfLeftLeaves1(root.right);
    return ans;
  }

  public static void main(String[] args) {
    int nullSub = 0;
    List<Integer> treeNodesVal= List.of(1,2,3,4,5);
    List<Integer> b = new ArrayList<>();
    for (Integer val :treeNodesVal) {
      if (val!=nullSub) b.add(val);
      else b.add(null);
    }
    TreeNode p0 = TreeNode.populate(b);

    System.out.println( sumOfLeftLeaves(p0) );
    System.out.println( sumOfLeftLeaves1(p0) );
  }
}
