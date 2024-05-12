import java.util.ArrayList;
import java.util.List;

public class lc61 {
  private static ListNode rotateRight(ListNode head, int k){
    List<ListNode> memo = new ArrayList<>(500);
    ListNode cp = head;
    int counter = 0;
    while( cp!=null){
      memo.add(cp);
      counter++;
      cp=cp.next;
    }
    if(counter==0) return null;
    int rotation = k%counter;
    if (rotation ==0) return head;
    // List<ListNode>subarray = memo.subList(counter-rotation, counter-1);
    ListNode newHead = memo.get(counter-rotation);
    memo.get( counter-1).next = head;
    ListNode tail = memo.get(counter-rotation-1);
    tail.next=null;
    return newHead;
  }
}
