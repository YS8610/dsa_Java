import java.util.ArrayList;
import java.util.List;

public class lc19 {
  
  public ListNode removeNthFromEnd(ListNode head, int n){
    List<ListNode> memo = new ArrayList<>(30);
    ListNode cp = head;
    while(cp!=null){
      memo.add(cp);
      cp=cp.next;
    }
    if (memo.size()==1) return null;
    if (memo.size() == n) {
      memo.get(0).next=null;
      return memo.get(1);
    }
    ListNode pp = memo.get( memo.size()-n-1 );
    if (n==1){
      pp.next= null;
      return head;
    }
    cp = pp.next;
    pp.next = cp.next;
    return head;
  }
}
