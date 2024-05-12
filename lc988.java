import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class lc988 {
  private static List<Character> dfs2(TreeNode root, List<Character> a){
    if (root == null) return new LinkedList<>();
    if (root.left == null && root.right == null){
      a.add((char)(root.val + 'a'));
      return new LinkedList<>(a);
    }
    List<Character> l = dfs2(root.left, new LinkedList<>(a));
    List<Character> r = dfs2(root.right, new LinkedList<>(a));
    List<Character> tl;
    List<Character> tr;
    int lenl = l.size();
    int lenr = r.size();
    if (lenl > 0 && lenr > 0){
      l.add((char)(root.val + 'a'));
      tl = new LinkedList<>(l);
      r.add((char)(root.val + 'a'));
      tr = new LinkedList<>(r);
      for (int i=0, n=Math.min(lenl,lenr);i<=n;i++){
        if (tl.get(i) < tr.get(i)) return tl;
        if (l.get(i) > r.get(i)) return tr;
      }
      if (lenl <= lenr) return tl;
      return tr;
      }
    if (lenl > 0){
      l.add((char)(root.val + 'a'));
      return new LinkedList<>(l);
    }
    r.add((char)(root.val + 'a'));
    return new LinkedList<>(r);
  }

  private static <T> void reverseL(List<T> l){
    T tmp;
    int lp = -1;
    int rp = l.size();
    while (++lp < --rp){
      tmp = l.get(lp);
      l.set(lp, l.get(rp));
      l.set(rp, tmp);
    }
  }

  private static List<Character> dfs(TreeNode root, List<Character> a){
    if (root == null) return null;
    if (root.left == null && root.right == null){
      a.add((char)(root.val + 'a'));
      reverseL(a);
      return new ArrayList<>(a);
    }
    a.add((char)(root.val + 'a'));
    List<Character> l = dfs(root.left, new ArrayList<>(a));
    List<Character> r = dfs(root.right, new ArrayList<>(a));
    if (l != null && r != null){
      int lenl = l.size();
      int lenr = r.size();
      for (int i=0, n=Math.min(lenl,lenr);i<n;i++){
        if (l.get(i) < r.get(i)) return l;
        if (l.get(i) > r.get(i)) return r;
      }
      if (lenl <= lenr) return l;
      return r;
    }
    if (r ==null) return l;
    return r;
  }
  
  private static String smallestFromLeaf(TreeNode root) {
    List<Character> ans = dfs(root, new LinkedList<>());
    StringBuilder a = new StringBuilder(ans.size());
    for (char b :ans) a.append(b);
    return a.toString();
  }

  public static void main(String[] args) {
    int nullSub = 100;
    List<Integer> treeNodesVal= List.of(25,1,nullSub,0,0,1,nullSub,nullSub,nullSub,0);
    List<Integer> b = new ArrayList<>();
    for (Integer val :treeNodesVal) {
      if (val!=nullSub) b.add(val);
      else b.add(null);
    }
    TreeNode p0 = TreeNode.populate(b);
    System.out.println(dfs2(p0, new LinkedList<>()).toString());
    System.out.println(dfs(p0, new LinkedList<>()).toString());
    System.out.println(smallestFromLeaf(p0));

  }
}
