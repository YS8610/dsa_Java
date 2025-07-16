import java.util.ArrayList;
import java.util.List;

public class lc2900 {
  public List<String> getLongestSubsequence(String[] words, int[] groups) {
    List<String> ans = new ArrayList<>();
    List<String> tmp = new ArrayList<>();
    int l = words.length;
    int a;
    for (int i = 0; i < l; i++) {
      tmp.clear();
      a = groups[i];
      tmp.add(words[i]);

      for (int j = i + 1; j < l; j++) {
        if (a == groups[j])
          continue;
        a = groups[j];
        tmp.add(words[j]);
      }
      if (ans.size() < tmp.size()) {
        ans.clear();
        ans.addAll(tmp);
      }
    }
    return ans;
  }
}
