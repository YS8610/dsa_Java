import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc763 {
  static public List<Integer> partitionLabels(String s) {
    int l = s.length();
    List<Integer> ans = new ArrayList<>();
    int[] map = new int[26];
    for (int i = 0; i < l; i++)
      map[s.charAt(i) - 'a']++;
    int[] state = new int[26];
    int lp = -1;
    int count = 0;
    while (++lp < l) {
      count++;
      state[s.charAt(lp) - 'a']++;
      if (can(state, map)) {
        ans.add(count);
        count = 0;
        Arrays.fill(state, 0);
      }
    }
    return ans;
  }

  static private boolean can(int[] state, int[] map) {
    for (int i = 0; i < 26; i++)
      if (state[i] != 0 && state[i] != map[i])
        return false;
    for (int i = 0; i < 26; i++)
      if (state[i] != 0)
        map[i] = 0;
    return true;
  }

  public static void main(String[] args) {
    String s = "ababcbacadefegdehijhklij";
    System.out.println(partitionLabels(s).toString());
  }
}
