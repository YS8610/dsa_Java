import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

class lc1079{
  private static int numTilePossibilities(String tiles) {
    int l = tiles.length();
    int[] map = new int[26];
    for (int i =0; i<l;i++)
      map[tiles.charAt(i) - 'A']++;
    return helper(l, map, 0);
  }

  private static int helper(int strlen, int[] map, int l){
    if (l >= strlen) return 0;
    int ans = 0;
    for (int i=0; i<26; i++){
      if (map[i] == 0) continue;
      map[i]--;
      ans += 1+helper(strlen, map, l+1);
      map[i]++;
    }
    return ans;
  }

  private static int numTilePossibilities1(String tiles) {
    int l = tiles.length();
    Set<String> set = new HashSet<>();
    for (int i=0;i<l;i++){
      StringBuilder tmp = new StringBuilder();
      tmp.append(tiles.charAt(i));
      helper1(tiles, i, tmp, set, new boolean[l]);
    }
    return set.size(); 
  }

  private static void helper1(String tiles, int i, StringBuilder a, Set<String>set, boolean[] visited){
    if (visited[i]) return;
    int l = tiles.length();
    visited[i] = true;
    if (a.length()==l){
      set.add(a.toString());
      return;
    }
    if (a.length() > l) return;
    set.add(a.toString());
    for (int j =0;j<l;j++){
      StringBuilder tmp = new StringBuilder(a.toString());
      tmp.append(tiles.charAt((i+1+j)%l));
      helper1(tiles, (i+1+j)%l, tmp, set, Arrays.copyOf(visited, l));
    }
  }

  public static void main(String[] args){
    String tiles = "ABB";
    System.out.println(numTilePossibilities(tiles));
    System.out.println(numTilePossibilities1(tiles));
  }
}
