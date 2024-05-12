public class lc2485 {
  
  private static int pivotInteger(int n) {
    if (n==1) return 1;
    int[] memo = new int[n+1];
    memo[0] = 0;
    for(int i=1;i<=n;i++){
      memo[i] += memo[i-1]+i;
    }
    int j = n-1;
    while (j>=1 ){
      if (memo[n]-memo[j-1] - memo[j] ==0) return j;
      j--;
    }
    return -1;
  }

  public static void main(String[] args) {
    int n=288;
    System.out.println( pivotInteger(n));
    // for( int i=1;i<=1000;i++) System.out.println(i+" "+ pivotInteger(i));
  }
}
