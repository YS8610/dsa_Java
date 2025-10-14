import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc2273 {
  static public List<String> removeAnagrams(String[] words) {
    int l = words.length;
    List<String> ans = new ArrayList<>(l);
    int[] f1 = new int[26];
    int[] f2 = new int[26];
    int i = 0, j = 0;
    boolean tmp;
    while (i < l) {
      count(words[i], f1);
      j = i;
      while (++j < l) {
        count(words[j], f2);
        tmp = same(f1, f2);
        if (!tmp){
          Arrays.fill(f2, 0);
          break;
        }
        Arrays.fill(f2, 0);
      }
      ans.add(words[i]);
      i = j;
      Arrays.fill(f1, 0);
    }
    return ans;
  }

  static public void count(String word, int[] f1) {
    int l = word.length();
    for (int i = 0; i < l; i++)
      f1[word.charAt(i) - 'a']++;
  }

  static public boolean same(int[] f1, int[] f2) {
    for (int i = 0; i < 26; i++)
      if (f1[i] != f2[i])
        return false;
    return true;
  }

  public static void main(String[] args) {
    String[] words = {"abba","baba","bbaa","cd","cd"};
    System.out.println(removeAnagrams(words));
  }
}
