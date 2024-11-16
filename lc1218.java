import java.util.HashMap;
import java.util.Map;

public class lc1218 {

  private static int longestSubsequence(int[] arr, int difference) {
    int l = arr.length;
    Map<Integer, Integer> map = new HashMap<>();
    int[] dp = new int[l];
    int ans = 1;
    dp[l - 1] = 1;
    map.computeIfPresent(arr[l - 1], (k, v) -> v + 1);
    map.computeIfAbsent(arr[l - 1], k -> 1);
    for (int i = l - 2; i >= 0; i--) {
      if (map.containsKey(arr[i] + difference)) {
        dp[i] += map.get(arr[i] + difference) + 1;
        if (map.containsKey(arr[i])) map.put(
          arr[i],
          Math.max(dp[i], map.get(arr[i]))
        ); else map.put(arr[i], dp[i]);
        continue;
      }
      dp[i] = 1;
      map.put(arr[i], 1);
    }
    for (int d : dp) ans = Math.max(ans, d);
    return ans;
  }

  public int longestSubsequence1(int[] arr, int difference) {
    int n = arr.length;
    int[] memo = new int[n];
    int ans = 1;
    int cp = 0;
    for (int r = 0; r < n; r++) {
      for (int c = r; c < n; c++) {
        if (r == c) {
          memo[c] = 1;
          cp = c;
        } else if (arr[c] - arr[cp] != difference) memo[c] = memo[cp]; else {
          memo[c] = memo[cp] + 1;
          ans = Math.max(ans, memo[c]);
          cp = c;
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 5, 7, 8, 5, 3, 4, 2, 1 };
    int difference = -2;
    System.out.println(longestSubsequence(arr, difference));
  }
}
