public class lc92 {

  private static ListNode reverseBetween(ListNode head, int left, int right) {
    if (left == right) return head;
    ListNode[] nodes = new ListNode[right - left + 1];
    ListNode cp = head;
    int count = 0, index = 0;
    ListNode h = null, t = null;
    while (cp != null) {
      count++;
      if (left > 1) {
        if (count == left - 1) h = cp;
      }
      if (count >= left && count <= right) {
        nodes[index] = cp;
        index++;
      }
      cp = cp.next;
      if (count == right) t = cp;
    }
    if (h != null) {
      h.next = nodes[right - left];
      cp = nodes[right - left];
      for (int i = right - left - 1; i >= 0; i--) {
        cp.next = nodes[i];
        cp = nodes[i];
      }
      cp.next = t;
      return head;
    } else {
      cp = nodes[right - left];
      for (int i = right - left - 1; i >= 0; i--) {
        cp.next = nodes[i];
        cp = nodes[i];
      }
      cp.next = t;
      return nodes[right - left];
    }
  }

  public static void main(String[] args) {
    ListNode head = ListNode.populate(new int[] { 1, 2, 3, 4, 5 });
    int left = 1, right = 2;
    ListNode ans = reverseBetween(head, left, right);
    ListNode.stringify(ans);
  }
}
