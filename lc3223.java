public class lc3223 {

  private static int minimumLength(String s) {
    int l = s.length();
    int[] map = new int[26];
    for (int i = 0; i < l; i++) map[s.charAt(i) - 'a']++;
    int ans = 0;
    for (int m : map) {
      if (m < 3) ans += m; else if (m % 2 == 0) ans += 2; else ans++;
    }
    return ans;
  }

  public static void main(String[] args) {
    String s = "abaacbcbb";
    System.out.println(minimumLength(s));
  }
}
