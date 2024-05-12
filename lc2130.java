import java.util.ArrayList;
import java.util.List;

public class lc2130 {
  private static int pairSum(ListNode head) {
    ListNode cp = head;
    List<Integer> map = new ArrayList<>(100000);
    while(cp!=null){
      map.add(cp.val);
      cp=cp.next;
    }
    int len = map.size();
    int lp =0, rp =len-1;
    int ans=0;
    while (lp<rp){
      ans = Math.max(ans, map.get(lp)+map.get(rp));
      lp++;
      rp--;
    }
    return ans;
  }

  public static void main(String[] args) {
    ListNode head = ListNode.populate(new int[]{5,4,2,1});
    System.out.println(pairSum(head));
  }
}
