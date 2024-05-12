public class lc1588 {
  
  private static int sumOddLengthSubarrays(int[] arr){
    int n = arr.length;
    int[] memo = new int[n];
    memo[0]= arr[0];
    for(int i=1;i<n;i++) memo[i] = memo[i-1]+arr[i];
    int ans = memo[n-1];
    // size of sliding window
    for (int i=2;i<n;i+=2){
      // starting pt
      for(int j=0;j<n-i;j++){
        if (j==0) ans += memo[j+i];
        else ans+= memo[j+i] - memo[j-1];
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] arr = {10};
    System.out.println( sumOddLengthSubarrays(arr) );
  }
}
