import java.util.HashSet;
import java.util.Set;

public class lc142 {
  private static ListNode detectCycle(ListNode head){
    Set<ListNode> memo = new HashSet<>();
    ListNode cp = head;
    while(cp!=null){
      if (!memo.contains(cp))  memo.add(cp);
      else return cp;
      cp=cp.next;
    }
    return null;
  }
}
