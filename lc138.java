import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc138 {

  private static NodeR copyRandomList(NodeR head) {
    if (head==null) return null;
    NodeR cp = head;
    Map<NodeR, Integer> map = new HashMap<>();
    List<NodeR> nodes = new ArrayList<>(500);
    int count = 0;
    while (cp != null) {
      nodes.add(cp);
      map.put(cp, count);
      count++;
      cp = cp.next;
    }
    int n = nodes.size();
    int[] ran = new int[n];
    for (int i = 0; i < n; i++) {
      if (nodes.get(i).random == null) ran[i] = -1; 
      else ran[i] = map.get(nodes.get(i).random);
    }

    NodeR[] newList = new NodeR[n];
    for (int i = 0; i < n; i++) {
      newList[i] = new NodeR(nodes.get(i).val);
    }
    for (int i = 0; i < n - 1; i++) {
      newList[i].next = newList[i + 1];
      newList[i].random = ran[i] == -1 ? null : newList[ran[i]];
    }
    newList[n - 1].next = null;
    newList[n - 1].random = ran[n - 1] == -1 ? null : newList[ran[n - 1]];

    return newList[0];
  }

  public static void main(String[] args) {
    NodeR a = new NodeR(0);
    NodeR b = new NodeR(1);
    NodeR c = new NodeR(2);
    a.next = b;
    b.next = c;
    c.next = null;
    a.random = c;
    b.random = a;
    c.random=b;
    copyRandomList(a);
  }
}
