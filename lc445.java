import java.util.ArrayDeque;
import java.util.Deque;

public class lc445 {
  private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Deque<Integer> stack1 = new ArrayDeque<>();
    Deque<Integer> stack2 = new ArrayDeque<>();
    ListNode cp1 = l1;
    ListNode cp2 = l2;
    while (cp1 != null || cp2 != null) {
      if (cp1!=null) {
        stack1.add(cp1.val);
        cp1 = cp1.next;
      }
      if (cp2!=null) {
        stack2.add(cp2.val);
        cp2 = cp2.next;
      }
    }
    Deque<Integer> stack = new ArrayDeque<>();
    Integer s1=0, s2=0;
    while(!stack1.isEmpty()||!stack2.isEmpty()){
      s1 = stack1.pollLast();
      s2 = stack2.pollLast();
      stack.add( (s1==null?0:s1) + (s2==null?0:s2) );
    }
    int n = stack.size();
    int[] memo = new int[n + 1];
    int tempInt = 0;
    while (!stack.isEmpty()) {
      tempInt = stack.pollFirst() + memo[n];
      if (tempInt >= 10) {
        memo[n] = tempInt - 10;
        memo[n - 1] += 1;
      } else memo[n] = tempInt;
      n--;
    }
    int startInd = memo[0]==0?1:0;
    ListNode ans = new ListNode(memo[startInd]);
    ListNode cp = ans;
    for (int i = startInd+1,m=memo.length; i<m;i++){
      cp.next = new ListNode( memo[i]);
      cp = cp.next;
    }
    return ans;
  }

  public static void main(String[] args) {
    ListNode l1 = ListNode.populate(new int[]{5});
    ListNode l2 = ListNode.populate(new int[]{5});
    ListNode result = addTwoNumbers(l1, l2);
    ListNode.stringify(result);
  }
}
