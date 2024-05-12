public class lc83 {
  
  public ListNode deleteDuplicates(ListNode head){
    ListNode cp = head;
    while (cp!=null){
      ListNode np = cp.next;
      while (np!=null && np.next != null && cp.val == np.val){
        cp.next = np.next;
        np = cp.next;
      }
      if (np!=null && np.next==null && cp.val ==np.val){
        cp.next=null;
        return head;
      }
      cp = np;
    }
    return head;
  }
}