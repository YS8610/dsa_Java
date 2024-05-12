import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class lc257{

  private static List<String> binaryTreePaths(TreeNode root){
    List<List<Integer>> finalAns = new ArrayList<>(100);
    if (root.left!=null)helper(root.left, new ArrayList<>(Arrays.asList(root.val)), finalAns);
    if (root.right!=null)helper(root.right, new ArrayList<>(Arrays.asList(root.val)), finalAns);
    List<String> strAns = new ArrayList<>( finalAns.size() );
    if (root.left==null && root.right==null) {
      strAns.add( String.valueOf(root.val) );
      return strAns;
    }
    for (List<Integer> a : finalAns){
      String str="";
      for(int b : a) {
        str += String.valueOf(b)+"->" ;
      }
      str = str.substring(0, str.length()-2);
      strAns.add(str);
    }
    return strAns;
  }

  private static void helper(TreeNode root, List<Integer> ans, List<List<Integer>> finalAns){
    if (root.left==null && root.right==null) {
      ans.add(root.val);
      finalAns.add(new ArrayList<>(ans));
    }
    ans.add(root.val);
    if(root.left!=null) helper(root.left, new ArrayList<>(ans), finalAns);
    if(root.right!=null) helper(root.right, new ArrayList<>(ans), finalAns);
  }

  public static void main(String[] args) {
    int nullS = 0;
    List<Integer> treeNodesVal= List.of(1,2,3,5,6,7,8,9,10,11,12,13,14);
    List<Integer> b = new ArrayList<>();
    for (Integer val :treeNodesVal) {
      if (val!=nullS) b.add(val);
      else b.add(null);
    }
    TreeNode p0 = TreeNode.populate(b);
    System.out.println(  binaryTreePaths(p0).toString() );
  }


}