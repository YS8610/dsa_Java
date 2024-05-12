import java.util.ArrayList;
import java.util.List;

public class lc148 {
  private static ListNode sortList(ListNode head){
    ListNode cp = head;
    List<ListNode> list = new ArrayList<>(40000);
    while (cp!=null){
      list.add(cp);
      cp = cp.next;
    }
    if (list.isEmpty()) return null;
    list.sort((m1,m2) -> Integer.compare(m1.val, m2.val) );
    head = list.get(0);
    cp = head;
    for(int i=1,n=list.size();i<n;i++ ){
      cp.next=list.get(i);
      cp=cp.next;
    }
    cp.next=null;
    return head;
  }
}
