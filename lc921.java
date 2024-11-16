import java.util.ArrayDeque;
import java.util.Deque;

public class lc921 {

  private static int minAddToMakeValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    int ans = 0;
    for (int i = 0, n = s.length(); i < n; i++) {
      if (stack.isEmpty() && s.charAt(i) == '(') {
        stack.addLast('(');
        continue;
      }
      if (stack.isEmpty() && s.charAt(i) == ')') {
        ans++;
        continue;
      }
      if (s.charAt(i) == '(') stack.addLast('('); else stack.removeLast();
    }
    return ans + stack.size();
  }

  public static void main(String[] args) {
    String s = "(((";
    System.out.println(minAddToMakeValid(s));
  }
}
