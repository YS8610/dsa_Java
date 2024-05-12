public class lc3146 {

  private static int findPermutationDifference(String s, String t) {
    int[] memo = new int['z' - 'a' + 1];
    int l = s.length();
    int ans = 0;
    for (int i = 0; i < l; i++) memo[s.charAt(i) - 'a'] = i;
    for (int i = 0; i < l; i++) {
      ans += Math.abs(memo[t.charAt(i) - 'a'] - i);
    }
    return ans;
  }

  public static void main(String[] args) {
    String s = "abcde", t = "edbac";
    System.out.println(findPermutationDifference(s, t));
  }
}
