import java.util.ArrayList;
import java.util.List;

public class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }

  public static final ListNode populate( int[] array ){
    int n = array.length;
    if (n==0) return null;
    ListNode ans = new ListNode(array[0]);
    ListNode cp = ans;
    for (int i=1;i<n;i++){
      cp.next = new ListNode(array[i]);
      cp = cp.next;
    }
    cp.next = null;
    return ans;
  }

  public static void stringify( ListNode a ){
    List<Integer> ans = new ArrayList<>();
    while( a !=null){
      ans.add(a.val);
      a=a.next;
    }
    System.out.println( ans.toString() );
  }
}

// ListNode head = ListNode.populate(new int[]{1,2,3,3,4,4,5});