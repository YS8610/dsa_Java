class lc203{
  public static ListNode removeElements(ListNode head, int val){
    ListNode cp = head;
    ListNode pp = null;

    while(cp!=null){
      ListNode np = cp.next;
      if(pp==null && cp.val == val){
        cp.next =  null;
        cp=null;
        head=np;
        cp=np;
      }
      else if (np==null && cp.val == val){
        pp.next=null;
        break;
      }
      else if (cp.val == val){
        pp.next = np;
        cp = np;
      }
      else{
        pp=cp;
        cp=np;
      }
    }
    return head;
  }
}