import java.util.List;

public class lc100 {
  
  private static boolean isSameTree(TreeNode p, TreeNode q){
    if (p==null && q==null) return true;
    if (p==null && q!=null) return false;
    if (p!=null && q==null) return false;
    if (p!=null && q!=null && p.val != q.val) return false;
    if (!isSameTree(p.left, q.left)) return false;
    if (!isSameTree(p.right, q.right)) return false;
    return true;
  }

  public static void main(String[] args) {
    TreeNode p= TreeNode.populate(List.of(1,2,3));
    TreeNode q= TreeNode.populate(List.of(1,2));

    System.out.println( isSameTree(p, q) );
  }
}
