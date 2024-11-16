public class lc328 {
  private static ListNode oddEvenList(ListNode head) {
    if (head == null) return null;
    ListNode even = null;
    ListNode eventail = null;
    ListNode odd = head;
    ListNode oddtail= null;
    ListNode np = odd.next;
    while (odd != null){
      np = odd.next;
      if (np != null)
        odd.next = np.next;
      else
        odd.next = null;
      if (odd.next==null) oddtail = odd;
      odd = odd.next;
      if (np!=null)
        np.next= null;
      if (even == null){
        even = np;
        eventail = np;
      }
      else{
        eventail.next = np;
        eventail = eventail.next;
      }
    }
    oddtail.next = even;
    return head;
  }

  public static void main(String[] args) {
    ListNode test = ListNode.populate(new int[]{1,2,3,4,5,6,7,8,9,1,0});
    ListNode.stringify(oddEvenList(test));
    
  }

}
