import java.util.Arrays;

public class lc997 {
  private static int findJudge(int n, int[][] trust) {
    int[] memo = new int[n+1];
    int len = trust.length;
    for(int i=0; i<len;i++) memo[trust[i][0]]=1;
    int judge=0;
    for(int i=1; i<=n;i++){
      if (memo[i]==0) judge=i;
    }
    if (judge==0) return -1;
    Arrays.fill(memo, 0);
    for(int[] t:trust) memo[t[1]]++;
    if (memo[judge]==n-1) return judge;
    return -1;
  }

  public static void main(String[] args) {
    int n = 3;
    int[][] trust = {{1,3},{2,3},{3,1}};
    System.out.println(findJudge(n, trust));
  }
}
