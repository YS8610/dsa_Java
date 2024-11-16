public class lc440 {
  static int ans=0;
  static int count = 0;
  
  public lc440(){
    ans = 0;
    count = 0;
  }

  private static void dfs(int i, int n, int k){
    if (i > n) return ;
    if (count >= k) return;
    for (int j=0;j<=9;j++){
      if (i+j==0) continue;
      if (i+j > n) break;
      count++;
      if (count >= k ) {
        ans = i+j;
        break;
      }
      dfs((i+j)*10, n, k);
    }
  }
  
  private static int findKthNumber(int n, int k) {
    dfs(0, n, k);
    return ans;
  }

  public static void main(String[] args) {
    int n = 13, k = 2;
    System.out.println(findKthNumber(n, k));
  }
}
