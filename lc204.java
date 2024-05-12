public class lc204 {
  private static int countPrimes(int n){
    if (n <=2) return 0;
    int ans =0;
    boolean[] memo = new boolean[n];
    memo[0] = false;
    memo[1] = false;
    for (int i=2; i<n;i++) memo[i] = true;
    for(int i=2,m=(int)Math.sqrt(n);i<=m;i++){
      if (memo[i]) {
        for(int j=i+i;j<n;j+=i) memo[j] = false;
      }
      if (memo[i]) ans++;
    }
    for(int i=(int)Math.sqrt(n)+1;i<n;i++)
      if (memo[i]) ans++;
    return ans;
  }

  public static void main(String[] args) {
    int n =5000000;
    System.out.println(countPrimes(n));
  }
}
