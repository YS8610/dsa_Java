public class lc1672 {
  private static int maximumWealth(int[][] accounts) {
    int ans = accounts[0][0];
    int tmp = 0;
    for (int[] acct: accounts){
      tmp = 0;
      for (int a:acct) tmp += a;
      ans = Math.max(ans, tmp);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] accounts = {{1,2,3},{3,2,1}};
    System.out.println(maximumWealth(accounts));
  }
}
