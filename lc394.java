import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class lc394 {

  private static String decodeString(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    Deque<Integer> sNo = new ArrayDeque<>();
    LinkedList<Character> q = new LinkedList<>();
    int n = s.length();
    int j = 0;
    char top;
    int topNum;
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '[' || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')) {
        stack.addLast(s.charAt(i));
        continue;
      }
      if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
        j = 0;
        while ( i + j < n && s.charAt(i + j) >= '0' && s.charAt(i + j) <= '9') j++;
        sNo.add(Integer.parseInt(s.substring(i, i + j)));
        i += j - 1;
        continue;
      }
      top = stack.removeLast();
      q.clear();
      while (top != '[') {
        q.addFirst(top);
        top = stack.removeLast();
      }
      topNum = sNo.removeLast();
      for (int k=0;k<topNum;k++) stack.addAll(q);
    }
    StringBuilder ans = new StringBuilder(stack.size());
    while (!stack.isEmpty()) ans.append(stack.remove());
    return ans.toString();
  }

  public static void main(String[] args) {
    String s = "2[abc]3[cd]ef";
    System.out.println(decodeString(s));
  }
}
