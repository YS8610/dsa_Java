public class lc2816 {
  private static ListNode doubleIt(ListNode head) {
    ListNode cp;
    cp = head;
    int i = 0;
    boolean morethan10 = false;
    while (cp != null ) {
      i++;
      cp = cp.next;
    }
    int[] array = new int[i];
    cp = head;
    for (int j=0;j<i;j++){
      array[j] = cp.val * 2;
      cp = cp.next;
    }
    for (int j=i-1;j>=1;j--){
      if (array[j]>=10) {
        array[j] -=10;
        array[j-1] += 1; 
      }
    }
    cp = head;
    if (array[0]>=10) {
      morethan10 = true;
      cp.val = 1;
      array[0] %= 10;
      if (cp.next == null){
        cp.next = new ListNode(array[0]);
        return head;
      }
      cp = cp.next;
    }
    i = 0;
    while (cp !=null){
      cp.val = array[i];
      i++;
      if (cp.next == null) break;
      cp = cp.next;
    }
    if (morethan10) cp.next = new ListNode(array[i]);
    return head;
    }

    public static void main(String[] args) {
      ListNode head = ListNode.populate(new int[]{9,9,9});
      doubleIt(head);
      ListNode.stringify(head);
    }
}
