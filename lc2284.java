import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc2284 {

  private static String largestWordCount(String[] messages, String[] senders) {
    Map<String, Integer> map = new HashMap<>();
    int l = messages.length;
    int count;
    for (int i = 0; i < l; i++) {
      count = 0;
      for (int j = 0, n = messages[i].length(); j < n; j++) {
        if (messages[i].charAt(j) == ' ') count++;
      }
      if (map.containsKey(senders[i])) map.put(
        senders[i],
        map.get(senders[i]) + count + 1
      ); else map.put(senders[i], count + 1);
    }
    int maxCount = 0;
    for (Map.Entry<String, Integer> kv : map.entrySet()) maxCount =
      Math.max(maxCount, kv.getValue());
    List<String> a = new ArrayList<>();
    for (Map.Entry<String, Integer> kv : map.entrySet()) if (
      kv.getValue() == maxCount
    ) a.add(kv.getKey());
    if (a.size() == 1) return a.get(0);
    a.sort(Comparator.reverseOrder());
    return a.get(0);
  }

  public static void main(String[] args) {
    String[] messages = {
      "Hello userTwooo",
      "Hi userThree",
      "Wonderful day Alice",
      "Nice day userThree",
    };
    String[] senders = { "Alice", "userTwo", "userThree", "Alice" };
    System.out.println(largestWordCount(messages, senders));
  }
}
