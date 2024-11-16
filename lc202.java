import java.util.HashMap;
import java.util.Map;

public class lc202 {

  private static boolean happyis(int n, Map<Integer, Integer> map) {
    if (map.containsKey(n)) {
      if (map.get(n) == 1) return true;
      return false;
    }
    int tmp = n;
    int ans = 0;
    while (tmp / 10 != 0) {
      ans += (tmp % 10) * (tmp % 10);
      tmp /= 10;
    }
    ans += (tmp % 10) * (tmp % 10);
    map.put(n, ans);
    if (ans == 1) return true; else return happyis(ans, map);
  }

  private static boolean isHappy(int n) {
    return happyis(n, new HashMap<>());
  }

  public static void main(String[] args) {
    int n = 19;
    System.out.println(isHappy(n));
  }
}
