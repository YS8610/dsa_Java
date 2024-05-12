public class lc1669 {

  private static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
    ListNode tail2 = list2;
    ListNode cp = list2;
    int i = 0;
    ListNode startSplit = list2;
    ListNode preSplit = list1;
    while (cp != null) {
      if (cp.next == null) tail2 = cp;
      cp = cp.next;
    }
    cp = list1;
    while (cp != null) {
      if (i == a - 1 && a != 0) startSplit = cp;
      if (i == b) preSplit = cp;
      cp = cp.next;
      i++;
    }
    startSplit.next = list2;
    tail2.next = preSplit.next;
    preSplit.next = null;
    if (a == 0) return list2;
    return list1;
  }

  public static void main(String[] args) {}
}
