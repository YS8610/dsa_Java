import java.util.ArrayList;
import java.util.List;

public class lc1002 {

  private static List<String> commonChars(String[] words) {
    int l = words.length;
    int tmp = 0;
    List<String> ans = new ArrayList<>();
    int[][] map = new int[l]['z' - 'a' + 1];
    for (int j = 0; j < l; j++) {
      for (int i = 0, n = words[j].length(); i < n; i++) {
        map[j][words[j].charAt(i) - 'a'] += 1;
      }
    }

    for (int i = 0, n = 'z' - 'a' + 1; i < n; i++) {
      for (int j = 0; j < l; j++) {
        if (j == 0) tmp = map[j][i]; else tmp = Math.min(tmp, map[j][i]);
      }
      for (int k = 0; k < tmp; k++) {
        ans.add(String.valueOf((char) (i + 'a')));
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    String[] words = {"bella","label","roller"};
    System.out.println(commonChars(words).toString());
  }
}
