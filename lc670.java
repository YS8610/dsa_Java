import java.util.ArrayDeque;
import java.util.Deque;

public class lc670 {

  private static int maximumSwap(int num) {
    String str = String.valueOf(num);
    Deque<Character> s = new ArrayDeque<>();
    int l = str.length();
    for (int i = 0; i < l; i++) {
      if (s.isEmpty()) {
        s.add(str.charAt(i));
        continue;
      }
      while (!s.isEmpty() && s.peekLast() < str.charAt(i)) s.removeLast();
      s.add(str.charAt(i));
    }
    if (s.size() == l) return Integer.valueOf(str);
    int lp = 0;
    while (lp < l && s.peekFirst() == str.charAt(lp)){
      s.pop();
      lp++;
    }
    char swap1 = s.peekFirst();
    char[] subans = str.toCharArray();
    while (lp < l && subans[lp] >= swap1) lp++;
    char swap2 = subans[lp];
    subans[lp] = swap1;
    int rp = l - 1;
    while (rp >= 0 && subans[rp] != swap1) rp--;
    subans[rp] = swap2;
    int ans = 0;
    for (int i = 0, n = subans.length; i < n; i++) {
      ans = (subans[i] - '0') + 10 * ans;
    }
    return ans;
  }

  public static void main(String[] args) {
    int num = 98368;
    System.out.println(maximumSwap(num));
  }
}
