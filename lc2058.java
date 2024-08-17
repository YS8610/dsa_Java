import java.util.Arrays;

public class lc2058 {

  private static int[] nodesBetweenCriticalPoints(ListNode head) {
    int[] ans = new int[] { Integer.MAX_VALUE, -1 };
    int first = -1;
    int prev = -1;
    int i = 0;
    ListNode pp = null;
    ListNode cp = head;
    while (cp != null && cp.next != null) {
      if (pp == null) {
        pp = cp;
        cp = cp.next;
        i++;
        continue;
      }
      if (
        (pp.val < cp.val && cp.next.val < cp.val) ||
        (pp.val > cp.val && cp.next.val > cp.val)
      ) {
        if (first == -1) first = i;
        if (prev == -1) prev = i; else {
          ans[0] = Math.min(ans[0], i - prev);
          prev = i;
        }
      }
      pp = cp;
      cp = cp.next;
      i++;
    }
    if (first == prev) {
      ans[0] = -1;
      ans[1] = -1;
      return ans;
    }
    ans[1] = prev - first;
    return ans;
  }

  public static void main(String[] args) {
    int[] head = {5,3,1,2,5,1,2};
    ListNode h = ListNode.populate(head);
    System.out.println(Arrays.toString(nodesBetweenCriticalPoints(h)));
  }
}
