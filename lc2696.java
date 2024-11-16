import java.util.Stack;

public class lc2696 {

  private static int minLength(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0, n = s.length(); i < n; i++) {
      if (stack.isEmpty()) {
        stack.add(s.charAt(i));
        continue;
      }
      if (stack.peek() == 'A' && s.charAt(i) == 'B') {
        stack.pop();
        continue;
      }
      if (stack.peek() == 'C' && s.charAt(i) == 'D') {
        stack.pop();
        continue;
      }
      stack.add(s.charAt(i));
    }
    return stack.size();
  }

  private static int remove(char[] schar, int l) {
    int i = 0;
    int j = 0;
    int ans = 0;
    while (i < l) {
      j = 0;
      if (schar[i] == 'A' || schar[i] == 'C') {
        j = 1;
        while (i + j < l && schar[i + j] == '0') j++;
        if (i + j >= l) return ans;
        if (
          (schar[i] == 'A' && schar[i + j] == 'B') ||
          schar[i] == 'C' &&
          schar[i + j] == 'D'
        ) {
          schar[i] = '0';
          schar[i + j] = '0';
          ans += 2;
        }
      }
      if (j == 0) i++; else i += j;
    }
    return ans;
  }

  private static int minLength1(String s) {
    char[] schar = s.toCharArray();
    int l = s.length();
    int rm = 0;
    int prev = -1;
    while (prev != rm) {
      prev = rm;
      rm += remove(schar, l);
    }
    return l - rm;
  }

  public static void main(String[] args) {
    String s = "ABFCACDB";
    System.out.println(minLength(s));
  }
}
