import java.util.Arrays;

public class lc3335 {
  private static final int MOD = 1000000007;

  public static int lengthAfterTransformations(String s, int t) {
    long map[] = new long[26];
    int l = s.length();
    int x = t / 26;
    int y = t % 26;
    long[] tmp = new long[26];
    for (int i = 0; i < l; i++)
      map[s.charAt(i) - 'a']++;
    for (int i = 0; i < x; i++) {
      Arrays.fill(tmp, 0);
      for (int j = 0; j < 26; j++) {
        if (map[j] == 0)
          continue;
        if (j == 25) {
          tmp[0] += map[25];
          tmp[1] += map[25];
        } else
          tmp[j + 1] += map[j];
      }
      for (int j = 0; j < 26; j++)
        map[j] = (tmp[j] + map[j]) % MOD;

    }
    long ans = 0;
    for (long m : map) {
      ans += m;
      ans %= MOD;
    }
    for (int i = 0; i < 26; i++) {
      if (i + y < 26)
        continue;
      ans += map[i];
      ans %= MOD;
    }
    return (int) ans;
  }

  public static void main(String[] args) {
    String s = "abcyy";
    int t = 78;
    System.out.println(lengthAfterTransformations(s, t));
  }
}
