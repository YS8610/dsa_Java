import java.util.HashMap;
import java.util.Map;

public class lc2053 {

  private static String kthDistinct(String[] arr, int k) {
    Map<String, Integer> map = new HashMap<>();
    String ans = "";
    int count = 0;
    for (String s : arr) {
      map.computeIfPresent(s, (key, v) -> v + 1);
      map.computeIfAbsent(s, v -> 1);
    }
    for (String s : arr) {
      if (map.get(s) == 1) count++;
      if (count == k) return s;
    }
    return ans;
  }

  public static void main(String[] args) {
    String[] arr = {"d","b","c","b","c","a"};
    int k = 2;
    System.out.println(kthDistinct(arr, k));
  }
}
