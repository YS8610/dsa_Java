import java.util.Arrays;

public class lc1061 {
  static public String smallestEquivalentString(String s1, String s2, String baseStr) {
    int[] parent = new int[26];
    Arrays.fill(parent, -1);
    int l = s1.length();
    int p1, p2;
    for (int i = 0; i < l; i++) {
      if (s1.charAt(i) == s2.charAt(i))
        continue;
      p1 = findp(parent, s1.charAt(i) - 'a');
      p2 = findp(parent, s2.charAt(i) - 'a');
      if (p1==p2)
        continue;
      if (parent[p1] <= parent[p2]) {
        parent[p1] += parent[p2];
        parent[p2] = p1;
        parent[s2.charAt(i) - 'a'] = p1;
      } else {
        parent[p2] += parent[p1];
        parent[p1] = p2;
        parent[s1.charAt(i) - 'a'] = p2;
      }
    }
    for (int i = 0; i < 26; i++)
      if (parent[i] >= 0)
        parent[i] = findp(parent, i);
    for (int i = 0, tmp = 0; i < 26; i++) {
      if (parent[i] < 0)
        continue;
      tmp = 0;
      if (parent[i] > i) {
        tmp = parent[i];
        parent[i] = parent[tmp];
        parent[tmp] = i;
        for (int j = 0; j < 26; j++)
          if (parent[j] == tmp)
            parent[j] = i;
      }
    }
    char[] ans = new char[baseStr.length()];
    for (int i = 0; i < baseStr.length(); i++) {
      if (parent[baseStr.charAt(i) - 'a'] < 0)
        ans[i] = baseStr.charAt(i);
      else
        ans[i] = (char) (parent[baseStr.charAt(i) - 'a'] + 'a');
    }
    return String.valueOf(ans);
  }

  private static int findp(int[] parent, int i) {
    if (parent[i] < 0)
      return i;
    return findp(parent, parent[i]);
  }

  static public void main(String[] args){
    String s1 = "ddvexktmenioinkrgbpuhkuixocxgiwlbbdouqvrpnnrsdueot", s2 = "ksvvwxspkqnfsjqikdssbrwooshgrdhpliptxhacskrwgxsskn", baseStr = "pcjfbtxshbboarojnopmxvfmctzrwrgxzispbllycynlssjtqz";  
    System.out.println(smallestEquivalentString(s1, s2, baseStr));
  }
}
