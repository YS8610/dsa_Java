import java.util.ArrayList;
import java.util.List;

public class lc1721 {
  private static ListNode swapNodes(ListNode head, int k) {
    List<Integer> memo = new ArrayList<>();
    ListNode cp = head;
    while(cp!=null){
      memo.add(cp.val);
      cp=cp.next;
    }
    int counter=0;
    int len = memo.size();
    int swaplast = memo.get(k-1);
    int swapFirst = memo.get( len-k );
    
    cp = head;
    while (cp!=null){
      if (counter==k-1) cp.val = swapFirst;
      else if (counter == len-k) cp.val=swaplast;
      counter++;
      cp=cp.next;
    }
    return head;
  }
  private static ListNode swapNodes1(ListNode head, int k) {
    ListNode cp = head;
    int counter=0;
    ListNode firstNode=null;
    while(cp!=null){
      if(counter==k-1) firstNode = cp;
      cp=cp.next;
      counter++;
    }
    int secNodePos = counter-k;
    int temp = firstNode.val;

    cp=head;
    counter=0;
    while(cp!=null){
      if(counter==secNodePos) {
        firstNode.val = cp.val;
        cp.val = temp;
        break;
      }
      cp=cp.next;
      counter++;
    }

    return head;
  }

  public static void main(String[] args) {
    
    ListNode head = ListNode.populate(new int[]{1,2,3,4,5});
    // swapNodes(head, 2);
    swapNodes1(head, 2);
    ListNode.stringify(head);
  }
}
