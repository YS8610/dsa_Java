import java.util.ArrayDeque;
import java.util.Deque;

public class lc117 {
  private static Node1 connect(Node1 root){
    if (root==null) return null;
    Node1 cp = root;
    Node1 prev=null;
    Node1 top;
    Deque<Node1> q = new ArrayDeque<>();
    q.add(cp);
    while (!q.isEmpty()){
      for (int i =0, n=q.size();i<n;i++){
        top = q.pollFirst();
        if (top.left!=null) q.add(top.left);
        if (top.right!=null) q.add(top.right);
        if (i>0) prev.next = top;
        else if (i==n-1 && prev!=null) prev.next = null;
        else {if (prev!=null) prev.next=null;}
        prev = top;
      }
    }
    return root;
  }
}
