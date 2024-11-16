
public class lc172 {
  private static int trailingZeroes(int n) {
    if (n==0) return 0;
    int ans = 0;
    int tmp = 0;
    int[] memo = new int[n+1];
    for (int i = 0;i<=n;i+=5){
      if (i==0) continue;
      tmp = i;
      while (tmp%10==0 || tmp%5==0){
        memo[i]++;
        tmp/=5;
        if (memo[tmp] !=0){
          memo[i] += memo[tmp];
          break;
        }
      }
      ans += memo[i];
    }
    return ans;
  }


  public static void main(String[] args) {
    int n = 30;
    System.out.println( trailingZeroes(n) );
  }
}

