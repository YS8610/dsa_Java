import java.util.Arrays;

public class lc1170 {
  static public int[] numSmallerByFrequency(String[] queries, String[] words) {
    int l = words.length;
    int[] freq = new int[l];
    int[] ans = new int[queries.length];
    for (int i = 0; i < l; i++)
      freq[i] = freqSmallest(words[i]);
    Arrays.sort(freq);
    for (int i = 0, n = queries.length, tmp = 0; i < n; i++) {
      tmp = freqSmallest(queries[i]);
      ans[i] = bs(freq, tmp);
    }
    return ans;
  }

  static public int bs(int[] freq, int k) {
    int l = freq.length;
    if (k < freq[0])
      return l;
    if (k >= freq[l - 1])
      return 0;
    int lp = 0, rp = l - 1;
    int mp;
    while (lp < rp) {
      mp = lp + (rp - lp) / 2;
      if (freq[mp] > k)
        rp = mp;
      else
        lp = mp + 1;
    }
    return l - lp;
  }

  static public int freqSmallest(String w) {
    int[] map = new int[26];
    int l = w.length();
    for (int i = 0; i < l; i++)
      map[w.charAt(i) - 'a']++;
    for (int i = 0; i < 26; i++) {
      if (map[i] == 0)
        continue;
      return map[i];
    }
    return -1;
  }

  public static void main(String[] args){
    String[] queries = {"aabbabbb","abbbabaa","aabbbabaa","aabba","abb","a","ba","aa","ba","baabbbaaaa","babaa","bbbbabaa"}
    , words = {"b","aaaba","aaaabba","aa","aabaabab","aabbaaabbb","ababb","bbb","aabbbabb","aab","bbaaababba","baaaaa"};
    System.out.println(Arrays.toString(numSmallerByFrequency(queries, words)));
  }
}
