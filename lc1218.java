public class lc1218 {

  private static int longestSubsequence(int[] arr, int difference) {
    int n = arr.length;
    int[] memo = new int[n];
    int ans = 1;
    int cp = 0;
    for (int r = 0; r < n; r++) {
      for (int c = r; c < n; c++) {
        if (r == c) {
          memo[c] = 1;
          cp = c;
        }
        else if (arr[c] - arr[cp] != difference) memo[c] = memo[cp]; 
        else {
          memo[c] = memo[cp]+1;
          cp = c;
        }
      }
      ans = Math.max(ans, memo[n-1]);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 5, 7, 8, 5, 3, 4, 2, 1 };
    int difference = -2;
    System.out.println(longestSubsequence(arr, difference));
  }
}
