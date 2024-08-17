public class lc1823 {
  
  
  private static int findTheWinner(int n, int k) {
    if (n == 1) return 1;
    ListNode head = new ListNode(1);
    ListNode cp = head;
    for (int i =2;i<=n;i++){
      cp.next = new ListNode(i);
      cp = cp.next;
    }
    cp.next = head;
    while (cp.val != cp.next.val){
      
    }
    return 0;
  }

  public static void main(String[] args) {
    int n = 5, k = 2;
    System.out.println(findTheWinner(n, k));
  }
}
