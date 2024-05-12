import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class lc1609 {
  private static boolean isEvenOddTree(TreeNode root) {
    int lvl = 0;
    TreeNode temp;
    int num;
    Deque<TreeNode> q = new ArrayDeque<>();
    q.add(root);
    while (!q.isEmpty()){
      num = q.getFirst().val;
      for (int i = 0, n=q.size();i<n;i++){
        temp = q.pollFirst();
        if (temp.left!=null) q.add(temp.left);
        if (temp.right!=null) q.add(temp.right);
        if (lvl %2 == 0) {
          if (temp.val %2 ==0) return false;
        }
        else {
          if (temp.val %2 != 0) return false;
        }
        if (i !=0){
          if (lvl%2==0) {
            if (num >= temp.val) return false;
          }
          else{
            if (num <= temp.val) return false;
          }
        }
        num = temp.val;
      }
      lvl++;
    }
    return true;
  }

  public static void main(String[] args) {
    int nullSub = 0;
    List<Integer> treeNodesVal= List.of(1,10,4,3,nullSub,7,9,12,8,6,nullSub,nullSub,2);
    List<Integer> b = new ArrayList<>();
    for (Integer val :treeNodesVal) {
      if (val!=nullSub) b.add(val);
      else b.add(null);
    }
    TreeNode p0 = TreeNode.populate(b);
    System.out.println(isEvenOddTree(p0));
  }
}
