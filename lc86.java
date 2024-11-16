public class lc86 {

  public ListNode partition(ListNode head, int x) {
    if (head == null) return null;
    ListNode phead = null;
    ListNode ptail = null;
    ListNode cp = head;
    ListNode marker = null;
    ListNode np;
    if (cp.val >= x) marker = cp; else {
      while (cp != null && cp.next != null && cp.next.val < x) cp = cp.next;
      marker = cp;
    }
    if (marker.next == null) return head;
    while (cp != null && cp.next != null) {
      if (cp.next.val < x) {
        np = cp.next;
        cp.next = np.next;
        if (ptail == null) {
          np.next = null;
          phead = np;
          ptail = np;
        } else {
          np.next = null;
          ptail.next = np;
          ptail = ptail.next;
        }
        continue;
      }
      cp = cp.next;
    }
    if (ptail == null) return head;
    if (marker == head && marker.val >= x) {
      ptail.next = marker;
      return phead;
    }
    np = marker.next;
    ptail.next = np;
    marker.next = phead;
    return head;
  }
}
