public class lc1456 {

  private static int score(char a) {
    if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') return 1;
    return 0;
  }

  private static int maxVowels(String s, int k) {
    int ans = 0;
    int temp = 0;
    for (int i = 0; i < k; i++) {
      temp += score(s.charAt(i));
    }
    ans = temp;
    for (int i = 1, n = s.length(); i < n - k + 1; i++) {
      temp = temp - score(s.charAt(i - 1)) + score(s.charAt(i + k - 1));
      ans = Math.max(ans, temp);
      if (ans == k) return ans;
    }
    return ans;
  }

  public static void main(String[] args) {
    String s = "abciiidef";
    int k = 3;
    System.out.println(maxVowels(s, k));
  }
}
