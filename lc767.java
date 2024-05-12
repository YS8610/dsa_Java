import java.util.HashMap;
import java.util.Map;

public class lc767 {

  private static String reorganizeString(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int n = s.length();
    for (int i = 0; i < n; i++) {
      if (map.containsKey(s.charAt(i))) {
        map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
      } else map.put(s.charAt(i), 1);
    }
    char[] array = new char[n];
    for (char c : map.keySet()){
      
    }

    return "";
  }

  public static void main(String[] args) {
    String s = "aab";
    System.out.println(reorganizeString(s));
  }
}
