public class lc2483 {
  private static int bestClosingTime(String customers) {
    int n = customers.length();
    int[] dp = new int[n];
    dp[0] = customers.charAt(0) == 'Y' ? 1 : 0;
    int min = n + 1;
    int pos = n;
    for (int i = 1; i < n; i++) {
      if (customers.charAt(i) == 'Y')
        dp[i] = dp[i - 1] + 1;
      else
        dp[i] = dp[i - 1];
    }
    if (dp[n - 1] == 0)
      return 0;
    int penalty;
    int totalCus = dp[n - 1];

    for (int i = 0; i < n; i++) {
      penalty = totalCus - dp[i] + (i + 1) - dp[i];
      if (penalty < min) {
        min = penalty;
        pos = i;
      }
    }
    if (min > n - totalCus)
      pos = n;
    if (min >= totalCus)
      pos = -1;
    return pos + 1;
  }

  public int bestClosingTime1(String customers) {
    int l = customers.length();
    int penalty = l + 1;
    int[] prefix = new int[l + 1];
    for (int i = 0; i < l; i++)
      prefix[i + 1] = prefix[i] + (customers.charAt(i) == 'Y' ? 1 : 0);
    for (int i = 0; i <= l; i++)
      penalty = Math.min(penalty, prefix[l] - prefix[i] + i - prefix[i]);
    for (int i = 0; i <= l; i++)
      if (prefix[l] - prefix[i] + i - prefix[i] == penalty)
        return i;
    return 0;
  }

  public static void main(String[] args) {
    String customers = "NNNYNN";
    System.out.println(bestClosingTime(customers));
  }
}
