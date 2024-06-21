import java.util.ArrayDeque;
import java.util.Deque;

public class lc1404 {

  private static int numSteps(String s) {
    int len = s.length();
    int ans = 0;
    int tmp;
    int co = 0;
    Deque<Character> l = new ArrayDeque<>();
    for (int i = 0; i < len; i++) l.add(s.charAt(i));
    while (l.size() > 1) {
      tmp = l.removeLast() - '0';
      tmp += co;
      if (co > 0) co = 0;
      if (tmp == 0 || tmp == 2) {
        ans++;
        if (tmp == 2) co = 1;
      } else if (tmp == 1) {
        ans += 2;
        co++;
      }
    }
    if (co == 1) ans++;
    return ans;
  }

  public static void main(String[] args) {
    String  s = "1101";
    System.out.println(numSteps(s));
  }
}
