import java.util.ArrayDeque;
import java.util.Deque;

public class lc1190 {

  private static String reverseParentheses(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    int len = s.length();
    char[] a = new char[len];
    int j = 0;
    for (int i = 0; i < len; i++) {
      if (s.charAt(i) != ')') {
        stack.add(s.charAt(i));
        continue;
      }
      while (stack.peekLast() != '(') {
        a[j] = stack.removeLast();
        j++;
      }
      stack.removeLast();
      for (int k = 0; k < j; k++) stack.add(a[k]);
      j = 0;
    }
    StringBuilder ans = new StringBuilder(stack.size());
    while (!stack.isEmpty()) ans.append(stack.pollFirst());
    return ans.toString();
  }

  public static void main(String[] args) {
    String s = "(u(love)i)";
    System.out.println(reverseParentheses(s));
  }
}
