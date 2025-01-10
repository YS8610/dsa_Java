import java.util.Arrays;

class lc2559{
  private static int[] vowelStrings(String[] words, int[][] queries) {
    boolean[] vowel = new boolean[26];
    vowel['a'-'a'] = true;
    vowel['e'-'a'] = true;
    vowel['i'-'a'] = true;
    vowel['o'-'a'] = true;
    vowel['u'-'a'] = true;
    int l = words.length;
    int[] dp = new int[l];
    dp[0] = fit(words[0], vowel)?1:0;
    for (int i=1;i<l;i++)
      dp[i] = dp[i-1] + (fit(words[i], vowel)?1:0);
    int lq = queries.length;
    int[] ans = new int[lq];
    for (int i =0; i<lq;i++){
      if (queries[i][0] == 0){
        ans[i] = dp[queries[i][1]];
        continue;
      }
      ans[i] = dp[queries[i][1]] - dp[queries[i][0]-1];
    }
    return ans;
  }

  private static boolean fit(String word, boolean[] vowel){
     return vowel[word.charAt(0)-'a'] 
         && vowel[word.charAt(word.length()-1)-'a'];
  }

  public static void main(String[] args){
    String[] words = {"aba","bcb","ece","aa","e"};
    int[][] queries = {{0,2},{1,4},{1,1}};
    System.out.println(Arrays.toString(vowelStrings(words, queries)));
  }
}
