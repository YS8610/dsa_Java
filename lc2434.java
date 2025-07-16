import java.util.ArrayDeque;
import java.util.Deque;

public class lc2434 {
  public String robotWithString(String s) {
    int[] map = new int[26];
    int l = s.length();
    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < l; i++)
      map[s.charAt(i) - 'a']++;
    Deque<Character> stack = new ArrayDeque<>();
    char tmp;
    for (int i = 0; i < l; i++) {
      stack.add(s.charAt(i));
      map[s.charAt(i) - 'a']--;
      out: while (!stack.isEmpty()) {
        tmp = stack.peekLast();
        for (int j = 0; j < tmp - 'a'; j++)
          if (map[j] > 0)
            break out;
        ans.append(tmp);
        stack.pollLast();
      }
    }
    return ans.toString();
  }
}
