import java.util.Arrays;

public class lc518 {
  private static int change(int amount, int[] coins){
    int n = coins.length;
    Arrays.sort(coins);
    int[][] memo = new int[n][amount+1];
    // initialize way for 0 amount. Alawys 1 way to make 0 amt
    for(int[] a: memo ) a[0]=1;
    // initialize value for coin[0]
    for (int i=1;i<amount+1;i++){
      int remainder = i - coins[0];
      if (remainder <0) memo[0][i]=0;
      else if (remainder ==0) memo[0][i] = memo[0][0];
      else memo[0][i] = memo[0][remainder];
    }
    //  completing the table
    for (int row=1; row<n;row++ ){
      for (int col=1; col<amount+1;col++){
        int remainder = col - coins[row];
        if (remainder<0) memo[row][col] = memo[row-1][col];
        else if (remainder==0) memo[row][col] = memo[row][0]+memo[row-1][col];
        else memo[row][col] = memo[row][remainder] + memo[row-1][col];
      }
    }
    // System.out.println( Arrays.deepToString(memo) );
    return memo[n-1][amount];
  }

// 2d dynamical programming
  public static void main(String[] args) {
    int amount = 5;
    int[] coins = {1,2,5};
    System.out.println( change(amount, coins));

  }
}
