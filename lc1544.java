import java.util.ArrayDeque;
import java.util.Deque;

public class lc1544 {

  private static String makeGood(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    int diff = 'a' - 'A';
    for (int i = 0, n = s.length(); i < n; i++) {
      if (stack.isEmpty()) {
        stack.add(s.charAt(i));
        continue;
      }
      if (
        Math.abs(stack.peekLast() - s.charAt(i)) == diff
      ) stack.removeLast(); else stack.addLast(s.charAt(i));
    }
    char[] a = new char[stack.size()];
    int i = -1;
    while (!stack.isEmpty()) a[++i] = stack.removeFirst();
    return String.valueOf(a);
  }

  public static void main(String[] args) {
    String s = "abBAcC";
    System.out.println(makeGood(s));
  }
}
