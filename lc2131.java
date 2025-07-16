public class lc2131 {
  static public int longestPalindrome(String[] words) {
    int[][] map = new int[26][26];
    int ans = 0;
    for (String w : words)
      map[w.charAt(0) - 'a'][w.charAt(1) - 'a']++;
    int odd = 0;
    for (int i = 0; i < 26; i++){
      if (map[i][i] == 0)
        continue;
      if (map[i][i] % 2 == 1)
        odd = 1;
      ans += (map[i][i] / 2) * 4;
    }
    for (int i = 0; i < 26; i++)
      for (int j = i + 1; j < 26; j++){
        if (map[i][j]==0)
          continue;
        ans += Math.min(map[i][j], map[j][i]) * 4;
      }
    return ans+odd*2;
  }

  public static void main(String[] args){
    String[] words = {"ab","ty","yt","lc","cl","ab"};
    System.out.println(longestPalindrome(words));
  }
}
