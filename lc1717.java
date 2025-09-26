import java.util.ArrayDeque;
import java.util.Deque;

public class lc1717 {
  static public int maximumGain(String s, int x, int y) {
    int ans = 0;
    int l = s.length();
    char tmp;
    Deque<Character> stack = new ArrayDeque<>();
    Deque<Character> stack2 = new ArrayDeque<>();
    if (x >= y) {
      for (int i = 0; i < l; i++) {
        if (!stack.isEmpty() && stack.peekLast() == 'a' && s.charAt(i) == 'b') {
          stack.pollLast();
          ans += x;
        } else
          stack.add(s.charAt(i));
      }
      while (!stack.isEmpty()) {
        tmp = stack.poll();
        if (!stack2.isEmpty() && stack2.peekLast() == 'b' && tmp == 'a') {
          stack2.pollLast();
          ans += y;
        } else
          stack2.add(tmp);
      }
    } else {
      for (int i = 0; i < l; i++) {
        if (!stack.isEmpty() && stack.peekLast() == 'b' && s.charAt(i) == 'a') {
          stack.pollLast();
          ans += y;
        } else
          stack.add(s.charAt(i));
      }
      while (!stack.isEmpty()) {
        tmp = stack.poll();
        if (!stack2.isEmpty() && stack2.peekLast() == 'a' && tmp == 'b') {
          stack2.pollLast();
          ans += x;
        } else
          stack2.add(tmp);
      }
    }
    return ans;
  }

  public static void main(String[] args){
    String s = "cdbcbbaaabab";
    int x = 4, y = 5;
    System.out.println(maximumGain(s, x, y));
  }
}
