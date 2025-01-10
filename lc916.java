import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class lc916{

  private static List<String> wordSubsets(String[] words1, String[] words2) {
    List<String> ans = new ArrayList<>();
    int[] map = new int[26];
    int[] tmpmap = new int[26];
    for (String w:words2){
      for (int i=0, n=w.length();i<n;i++)
        tmpmap[w.charAt(i)-'a']++;
      for (int i=0;i<26;i++)
        map[i] = Math.max(map[i], tmpmap[i]);
      Arrays.fill(tmpmap, 0);
    }
    int[] tmp = new int[26];
    boolean include = true;
    for (String w:words1){
      for (int i=0, n=w.length();i<n;i++)
        tmp[w.charAt(i)-'a']++;
      for (int i=0;i<26;i++)
        if (tmp[i] < map[i])
          include = false;
      if (include)
        ans.add(w);
      Arrays.fill(tmp, 0);
      include = true;
    }
    return ans;
  }

  public static void main(String[] args){
    String[] words1 = {"amazon","apple","facebook","google","leetcode"};
    String[]  words2 = {"e","o"};
    System.out.println(wordSubsets(words1, words2).toString());
  }
}
