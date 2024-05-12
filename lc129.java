import java.util.ArrayList;
import java.util.List;


public class lc129 {
  
  private static int sumNumbers(TreeNode root){
    if (root==null) return 0;
    List<Integer> ans = new ArrayList<>();
    int sum =0;
    helper(root, "", ans);
    System.out.println( ans.toString() );
    for (int num:ans) sum+=num; 
    return sum;
  }
  private static void helper(TreeNode root, String input, List<Integer> nums){
    if (root.left==null && root.right==null) {
      String added = input+ String.valueOf(root.val);
      System.out.println(added);
      nums.add( Integer.parseInt(added) );
      return;
    }
    String added = input + String.valueOf(root.val);
    if (root.left!=null) helper(root.left, added, nums);
    if (root.right!=null) helper(root.right, added, nums);
  }

  private static int dfs(TreeNode root, int sum){
    if (root == null) return 0;
    if (root.left == null & root.right == null)
      return 10 * sum + root.val;
    
    int res = 0;
    sum = 10 * sum + root.val;
    res = dfs(root.left, sum) + dfs(root.right, sum);
    return res;
  }

  private static int sumNumbers1(TreeNode root){
    if (root == null) return 0;
    return dfs(root,0);
  }

  public static void main(String[] args) {
    int nullSub = 0;
    List<Integer> treeNodesVal= List.of(4,3,5,0,8);
    List<Integer> b = new ArrayList<>();
    for (Integer val :treeNodesVal) {
      if (val!=nullSub) b.add(val);
      else b.add(nullSub);
    }
    TreeNode p0 = TreeNode.populate(b);
    System.out.println(sumNumbers(p0));
    System.out.println(sumNumbers1(p0));

  }

}
