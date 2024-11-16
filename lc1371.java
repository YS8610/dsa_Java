import java.util.HashMap;
import java.util.Map;

public class lc1371 {
  private static int findTheLongestSubstring(String s) {
    int l = s.length();
    int[] map = new int[26];
    boolean[] v= new boolean[26];
    Map<Integer,Integer> prefix = new HashMap<>();
    int tmp = 0;
    int ans = 0;
    v['a'-'a'] = true;
    v['e'-'a'] = true;
    v['i'-'a'] = true;
    v['o'-'a'] = true;
    v['u'-'a'] = true;
    map['a'-'a'] = 0;
    map['e'-'a'] = 1;
    map['i'-'a'] = 2;
    map['o'-'a'] = 3;
    map['u'-'a'] = 4;
    prefix.put(0, -1);
    for (int i =0; i<l;i++){
      tmp ^= v[s.charAt(i) - 'a']? 1<<map[s.charAt(i) - 'a'] :0;
      if (prefix.containsKey(tmp)){
        ans = Math.max(ans, i - prefix.get(tmp));
        continue;
      }
      prefix.put(tmp, i);
    }
    return ans;
  }

  public static void main(String[] args) {
    String s = "amntyyaw";
    System.out.println(findTheLongestSubstring(s));
  }
}
