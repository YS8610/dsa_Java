import java.util.HashSet;
import java.util.Set;

public class lc3217 {

  public ListNode modifiedList(int[] nums, ListNode head) {
    ListNode cp = head;
    Set<Integer> set = new HashSet<>();
    for (int n : nums) set.add(n);
    while (set.contains(cp.val)) {
      head = cp.next;
      cp.next = null;
      cp = head;
    }
    ListNode np = cp.next;
    while (np != null) {
      if (set.contains(np.val)) {
        cp.next = np.next;
        np.next = null;
        np = cp.next;
        continue;
      }
      cp = np;
      np = np.next;
    }
    return head;
  }
}
