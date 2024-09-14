public class lc2807 {

  private static int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
  }

  private static void travel(ListNode head) {
    if (head.next == null) return;
    ListNode np = head.next;
    head.next = new ListNode(gcd(head.val, np.val));
    head.next.next = np;
    travel(np);
  }

  public ListNode insertGreatestCommonDivisors(ListNode head) {
    travel(head);
    return head;
  }
}
