import java.util.ArrayList;
import java.util.List;

public class lc113 {
  
  private static List<List<Integer>> pathSum(TreeNode root, int targetSum){
    List<List<Integer>> ans = new ArrayList<>();
    if (root==null) return ans;
    helper(root, targetSum, new ArrayList<>(), ans);
    return ans;
  }
  
  private static void helper(TreeNode root, int targetSum, List<Integer> pAns, List<List<Integer>> ans ){
    int remainder = targetSum - root.val;
    pAns = new ArrayList<>(pAns);
    pAns.add(root.val);
    if (root.left==null && root.right==null && remainder==0) {
      ans.add(new ArrayList<>(pAns));
    }
    if (root.left!=null) helper(root.left, remainder, pAns, ans);
    if (root.right!=null) helper(root.right, remainder, pAns, ans);
  }

    public static void main(String[] args) {
    int nullSub = 0;
    List<Integer> treeNodesVal= List.of(5,4,8,11,nullSub,13,4,7,2,nullSub,nullSub,5,1);
    List<Integer> b = new ArrayList<>();
    for (Integer val :treeNodesVal) {
      if (val!=nullSub) b.add(val);
      else b.add(null);
    }
    System.out.println( b.toString());
    TreeNode p0 = TreeNode.populate(b);
    int targetSum = 22;
    System.out.println( pathSum(p0, targetSum) );
  }
}
