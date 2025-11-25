public class lc237 {

  public void deleteNode(ListNode node){
    ListNode cp = node;
    ListNode pp = null;
    while(cp!=null){
      ListNode np = cp.next;
      if (np==null){
        System.out.println( cp.val);
        pp.next = null;
        break;
      }
      cp.val = np.val;
      pp=cp;
      cp=np;
    }
  }
}
