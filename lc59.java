import java.util.Arrays;

public class lc59 {
  
  private static int[][] generateMatrix(int n){
    int[][] ans = new int[n][n];
    int lp = 0, rp = n - 1;
    int up = 0, dp=n-1;
    int counter=1;
    while (lp < rp) {
      for(int i=lp; i<=rp;i++){
        ans[up][i]=counter;
        counter++;
      }
      up++;
      for (int i=up; i<=dp;i++){
        ans[i][rp] = counter;
        counter++;
      }
      rp--;
      for (int i=rp;i>=lp;i--){
        ans[dp][i]=counter;
        counter++;
      }
      dp--;
      for(int i=dp;i>=up;i-- ){
        ans[i][lp]=counter;
        counter++;
      }
      lp++;
    }
    if (n%2!=0) ans[n/2][n/2]=counter; 
    return ans;
  }

  public static void main(String[] args) {
    int n = 4;
    System.out.println( Arrays.deepToString(generateMatrix(n)) );
  }
}
