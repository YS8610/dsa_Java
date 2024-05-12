import java.util.Arrays;
import java.util.Random;

public class lc382 {
  int len;
  int[] memo;
  Random rand;

  public lc382(ListNode head){
    ListNode cp = head;
    this.len = 0;
    while (cp != null && ++this.len >= 0)
      cp = cp.next;
    this.memo = new int[this.len];
    cp = head;
    this.len = -1;
    while (cp != null){
      this.memo[++this.len] = cp.val;
      cp = cp.next;
    }
    this.len++;
    this.rand = new Random();
  }

  public int getRandom() {
    return this.memo[this.rand.nextInt(this.len)];
  }

  public static void main(String[] args) {
    ListNode head = ListNode.populate(new int[]{1,2,3,3,4,4,5});
    lc382 a = new lc382(head);
    System.out.println(Arrays.toString(a.memo));
    System.out.println(a.len);
    System.out.println(a.getRandom());
  }
}
