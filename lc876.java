public class lc876 {
  public ListNode middleNode(ListNode head){
    int len = 0;
    ListNode cp = head;
    while (cp != null){
      len++;
      cp = cp.next;
    }
    int target = len /2;
    cp = head;
    len = 0;
    while (cp != null){
      if (len == target) return cp;
      cp = cp.next;
      len++;
    }
    return cp;
  }
}
