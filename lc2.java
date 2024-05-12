public class lc2 {

  private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode cp1 = l1;
    ListNode cp2 = l2;
    int[] memo = new int[101];
    int counter = 0;
    int sum = 0;
    int total = 0;
    while (cp1 != null || cp2 != null) {
      sum = (cp1 == null ? 0 : cp1.val) + (cp2 == null ? 0 : cp2.val);
      total = sum + memo[counter];
      if (total > 9) {
        memo[counter] = total - 10;
        memo[counter + 1]++;
      } else memo[counter] = total;
      counter++;
      if (cp1!=null && cp1.next != null) cp1 = cp1.next;
      else cp1=null;
      if (cp2!=null && cp2.next != null) cp2 = cp2.next;
      else cp2=null;
    }
    counter = memo[counter]==0?counter-1:counter;
    ListNode ans = new ListNode(memo[0]);
    ListNode cp = ans;
    for (int i = 1; i <=counter; i++) {
      cp.next = new ListNode(memo[i]);
      cp = cp.next;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] a1 = { 5,6,4 }, a2 = { 2,4,3 };
    ListNode l1 = ListNode.populate(a1);
    ListNode l2 = ListNode.populate(a2);
    ListNode ans = addTwoNumbers(l1, l2);
    ListNode.stringify(ans);
  }
}
