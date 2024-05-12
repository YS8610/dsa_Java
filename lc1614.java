import java.util.ArrayDeque;
import java.util.Deque;

public class lc1614 {
  private static int maxDepth(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    int ans = 0;
    for (int i = 0, n = s.length(); i < n; i++) {
      if (s.charAt(i) == '(') stack.add('('); else if (
        s.charAt(i) == ')'
      ) stack.removeLast();
      ans = Math.max(ans, stack.size());
    }
    return ans;
  }

  public static void main(String[] args) {
    String s = "(1+(2*3)+((8)/4))+1";
    System.out.println(maxDepth(s));
  }
}
