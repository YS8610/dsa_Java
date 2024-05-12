public class lc725 {

  private static ListNode[] splitListToParts(ListNode head, int k) {
    if (head == null) return new ListNode[k];
    ListNode cp = head;
    int n = 0;
    while (cp != null) {
      n++;
      cp = cp.next;
    }
    ListNode[] ans;
    if (k == 1) {
      ans = new ListNode[1];
      ans[0] = head;
      return ans;
    }
    ListNode prev;
    if (n < k) {
      ans = new ListNode[k];
      cp = head;
      for (int i = 0; i < n; i++) {
        ans[i] = cp;
        prev = cp;
        cp = cp.next;
        prev.next = null;
      }
      return ans;
    } else if (n == k) {
      ans = new ListNode[n];
      cp = head;
      for (int i = 0; i < n; i++) {
        ans[i] = cp;
        prev = cp;
        cp = cp.next;
        prev.next = null;
      }
      return ans;
    }
    // n>k
    else {
      cp = head;
      ListNode[] nodes = new ListNode[n];
      for (int i = 0; i < n; i++) {
        nodes[i] = cp;
        cp = cp.next;
      }
      int num = n / k;
      int remainder = n % k;
      // there are equal parts
      ans = new ListNode[k];
      if (remainder == 0) {
        for (int i = 0; i < k; i++) {
          ans[i] = nodes[i * num];
          cp = nodes[i * num + num - 1];
          prev = cp;
          cp = cp.next;
          prev.next = null;
        }
        return ans;
      }
      // remainder is not zero
      else {
        for (int i = 0; i < remainder; i++) {
          ans[i] = nodes[i * (num + 1)];
          cp = nodes[i * (num + 1) + num];
          prev = cp;
          cp = cp.next;
          prev.next = null;
        }
        for (int i = remainder; i < k; i++) {
          ans[i] = nodes[(remainder * (num + 1) + (i - remainder) * num)];
          cp =
            nodes[(remainder * (num + 1) + (i - remainder) * num) + (num - 1)];
          prev = cp;
          cp = cp.next;
          prev.next = null;
        }
        return ans;
      }
    }
  }

  public static void main(String[] args) {
    ListNode head = ListNode.populate(new int[] { 1, 2, 3, 4 });
    splitListToParts(head, 2);
  }
}
