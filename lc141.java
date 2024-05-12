import java.util.HashSet;
import java.util.Set;

public class lc141 {
  
  private static boolean hasCycle(ListNode head) {
    Set<ListNode> set = new HashSet<>();
    ListNode current = head;
    int counter = 0;
    if (head==null) return false;
    while (current!=null){
      set.add(current);
      counter ++;
      if (set.size() !=counter) return true;
      current = current.next;
    }
    return false;
  }

  public static void main(String[] args) {
    ListNode a = new ListNode(1);
    ListNode b = new ListNode(2);
    ListNode c = new ListNode(3);
    ListNode d = new ListNode(4);
    a.next = b;
    b.next = c;
    c.next = d;
    // d.next = a;
    System.out.println(hasCycle(a));
  }
}
