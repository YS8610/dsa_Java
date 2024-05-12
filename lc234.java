import java.util.LinkedList;

public class lc234 {
  private static boolean isPalindrome(ListNode head){
    ListNode cp = head;
    LinkedList<Integer> memo = new LinkedList<>();
    LinkedList<Integer> memo1 = new LinkedList<>();
    while(cp!=null){
      memo.addFirst(cp.val);
      memo1.addLast(cp.val);
      cp= cp.next;
    }

    return memo.equals(memo1)?true:false;
  }
}
