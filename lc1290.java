public class lc1290 {
  public int getDecimalValue(ListNode head) {
    boolean[] map = new boolean[30];
    ListNode cp = head;
    int i = 0;
    int ans = 0;
    while (cp != null) {
      map[i++] = cp.val == 1 ? true : false;
      cp = cp.next;
    }
    for (int j = i - 1, bitmask = 1; j >= 0; j--) {
      if (!map[j]) {
        bitmask <<= 1;
        continue;
      }
      if (j == i - 1)
        ans += 1;
      else
        ans += bitmask;
      bitmask <<= 1;
    }
    return ans;
  }
}
