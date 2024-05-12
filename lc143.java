import java.util.ArrayList;
import java.util.List;

public class lc143 {
  
  private static void reorderList(ListNode head){
    ListNode cp = head;
    List<ListNode> memo = new ArrayList<>(50000);
    while(cp!=null){
      memo.add(cp);
      cp=cp.next;
    }
    int n = memo.size();
    ListNode[] listnode = new ListNode[n];
    cp = head;
    for(int i=0,m=n/2;i<m;i++) {
      listnode[i*2] = memo.get(i);
      listnode[i*2+1] = memo.get(n-1-i);
    }
    if (n%2!=0) listnode[n-1] = memo.get(n/2);
    head = listnode[0];
    cp = head;
    for( int i=1;i<n;i++){
      cp.next = listnode[i];
      cp=cp.next;
    }
    listnode[n-1].next=null;
  }

  public static void main(String[] args) {
    ListNode head = ListNode.populate(new int[]{1,2,3});
    reorderList(head);
    ListNode.stringify(head);
  }
}
