import java.util.HashSet;
import java.util.Set;

public class lc3217 {

  public ListNode modifiedList(int[] nums, ListNode head) {
    ListNode cp = head;
    Set<Integer> set = new HashSet<>();
    for (int n : nums)
      set.add(n);
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

  static public ListNode modifiedList1(int[] nums, ListNode head) {
    Set<Integer> set = new HashSet<>();
    for (int n : nums)
      set.add(n);
    ListNode cp = head;
    return delete(set, head, null, cp);
  }

  static public ListNode delete(Set<Integer> set, ListNode head, ListNode pp, ListNode cp) {
    if (cp == null)
      return head;
    if (set.contains(cp.val) && pp == null) {
      ListNode np = cp.next;
      head.next = null;
      head = np;
      return delete(set, head, null, np);
    }
    if (set.contains(cp.val)) {
      pp.next = cp.next;
      return delete(set, head, pp, cp.next);
    }
    return delete(set, head, cp, cp.next);
  }

  public static void main(String[] args) {
    ListNode head = ListNode.populate(new int[] { 1, 2, 3, 4, 5 });
    int[] num = new int[] { 1, 2, 3 };
    ListNode.stringify(modifiedList1(num, head));
  }
}
