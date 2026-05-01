import java.util.Iterator;
import java.util.LinkedList;

public class lc1461 {
  static public boolean hasAllCodes(String s, int k) {
    if (s.length() < k)
      return false;
    int l = s.length();
    LinkedList<Character> list = new LinkedList<>();
    int total = 1 << k;
    boolean[] set = new boolean[total];
    int count = 0;
    for (int i = 0; i < k; i++)
      list.add(s.charAt(i));
    set[convert(list)] = true;
    count++;
    for (int i = 1, tmp = 0, n = l - k; i <= n; i++) {
      list.poll();
      list.add(s.charAt(i + k - 1));
      tmp = convert(list);
      if (set[tmp])
        continue;
      set[tmp] = true;
      count++;
      if (count == total)
        return true;
    }
    return false;
  }

  static private int convert(LinkedList<Character> str) {
    int l = str.size();
    Iterator<Character> it = str.iterator();
    int ans = 0;
    char tmp;
    while (it.hasNext()) {
      --l;
      tmp = (char) it.next();
      if (tmp == '0')
        continue;
      ans += 1 << l;
    }
    return ans;
  }

  public static void main(String[] args) {
    String s = "00110";
    int k = 2;
    System.out.println(hasAllCodes(s, k));
  }
}
