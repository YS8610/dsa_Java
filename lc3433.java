import java.util.List;
import java.util.Collections;
import java.util.Arrays;

public class lc3433 {
  public int[] countMentions(int numberOfUsers, List<List<String>> events) {
    int[] ans = new int[numberOfUsers];
    int all = 0;
    int[] lastStatus = new int[numberOfUsers];
    Arrays.fill(lastStatus, -60);
    Collections.sort(events, (m1, m2) -> {
      int t1 = Integer.parseInt(m1.get(1));
      int t2 = Integer.parseInt(m2.get(1));
      if (t1 == t2)
        return m2.get(0).compareTo(m1.get(0));
      return Integer.compare(t1, t2);
    });
    // System.out.println(events.toString());
    String eType;
    String timeStampStr;
    String content;
    for (List<String> e : events) {
      eType = e.get(0);
      timeStampStr = e.get(1);
      content = e.get(2);
      // handle offline event
      if (eType.equals("OFFLINE")) {
        lastStatus[Integer.parseInt(content)] = Integer.parseInt(timeStampStr);
        continue;
      }
      // handle message event
      // handle all
      if (content.equals("ALL")) {
        all++;
        continue;
      }
      // handle online user only
      if (content.equals("HERE")) {
        for (int i = 0; i < numberOfUsers; i++) {
          if (lastStatus[i] + 60 > Integer.parseInt(timeStampStr))
            continue;
          ans[i]++;
        }
        continue;
      }
      // handle specific user
      int l = content.length();
      int tmp = 0;
      for (int i = 0; i < l; i++) {
        if (Character.isAlphabetic(content.charAt(i))) {
          tmp = 0;
          continue;
        }
        if (content.charAt(i) == ' ') {
          ans[tmp]++;
          continue;
        }
        tmp = tmp * 10 + (content.charAt(i) - '0');
      }
      ans[tmp]++;
    }
    for (int i = 0; i < numberOfUsers; i++)
      ans[i] += all;
    return ans;
  }
}
