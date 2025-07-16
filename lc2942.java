import java.util.ArrayList;
import java.util.List;

public class lc2942 {
  public List<Integer> findWordsContaining(String[] words, char x) {
    List<Integer> ans = new ArrayList<>();
    int l = words.length;
    for (int j = 0; j < l; j++) {
      for (int i = 0, n = words[j].length(); i < n; i++) {
        if ((words[j]).charAt(i) == x) {
          ans.add(j);
          break;
        }
      }
    }
    return ans;
  }
}
