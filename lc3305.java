import java.util.Arrays;

public class lc3305 {
  private static int countOfSubstrings(String word, int k) {
    int[] map = new int[26];
    int l = word.length();
    int lp = 0, rp = lp+5+k-1; 
    int ans = 0;
    while (lp < l && rp < l){
      rp = lp + 5 + k;
      Arrays.fill(map, 0);
      for (int i =lp; i<rp;i++){
        if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u')
          map[word.charAt(i) - 'a']++;
        else map[25]++;
      }
      if (map['a' - 'a']>0 && map['e' - 'a']>0 && map['i' - 'a']>0 && map['o' - 'a']>0 && map['u' - 'a']>0 && map[25] == k){
        ans++;
      }
      else {
        lp++;
        continue;
      }
      rp++;
      if (rp >= l) continue;
    }
    return ans;
  }

  public static void main(String[] args) {
    String word = "ieaouqqieaouqq";
    int k = 1;
    System.out.println(countOfSubstrings(word, k));
  }
}
