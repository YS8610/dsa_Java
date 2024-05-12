public class lc24 {

  private static ListNode swapPairs(ListNode head) {
    if (head == null) return null;
    if (head.next == null) return head;
    ListNode pp = null;
    ListNode cp = head;
    ListNode np = cp.next;
    if (np == null) return head;
    ListNode h = cp.next;
    cp.next = np.next;
    h.next = cp;
    pp = cp;
    cp = cp.next;

    while (cp != null) {
      np = cp.next;
      if (np == null) return h;
      pp.next = np;
      cp.next = np.next;
      np.next = cp;
      pp = cp;
      cp = cp.next;
    }
    return h;
  }

  public static void main(String[] args) {
    ListNode head = ListNode.populate(new int[] { 1, 2, 3, 4, 5 });
    ListNode ans = swapPairs(head);
    ListNode.stringify(ans);
  }
}
