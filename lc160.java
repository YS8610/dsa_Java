import java.util.ArrayList;
import java.util.List;

public class lc160 {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode cpA = headA;
    ListNode cpB = headB;
    List<ListNode> nA = new ArrayList<>();
    List<ListNode> nB = new ArrayList<>();
    while (cpA != null) {
      nA.add(cpA);
      cpA = cpA.next;
    }
    while (cpB != null) {
      nB.add(cpB);
      cpB = cpB.next;
    }
    int lenA = nA.size();
    int lenB = nB.size();
    if (nA.get(lenA - 1) != nB.get(lenB - 1)) return null;
    for (int i = lenA <= lenB ? lenA - 1 : lenB - 1; i >= 0; i--) {
      if (nA.get(lenA - 1) != nB.get(lenB - 1)) return nA.get(lenA);
      lenA--;
      lenB--;
    }
    return lenA <= lenB ? headA : headB;
  }

  public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
    ListNode cpA = headA;
    ListNode cpB = headB;
    List<ListNode> nA = new ArrayList<>();
    List<ListNode> nB = new ArrayList<>();
    while (cpA != null) {
      nA.add(cpA);
      cpA = cpA.next;
    }
    while (cpB != null) {
      nB.add(cpB);
      cpB = cpB.next;
    }
    int lenA = nA.size();
    int lenB = nB.size();
    if (nA.get(lenA - 1) != nB.get(lenB - 1)) return null;
    for (int i = lenA <= lenB ? lenA - 1 : lenB - 1; i >= 0; i--) {
      if (nA.get(lenA - 1) != nB.get(lenB - 1)) return nA.get(lenA);
      lenA--;
      lenB--;
    }
    return lenA <= lenB ? headA : headB;
  }
}
