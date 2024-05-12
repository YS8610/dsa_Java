import java.util.HashMap;
import java.util.Map;

public class lc397 {
  
  private static Map<Integer,Integer> memo = new HashMap<>();
  
  private static int integerReplacement(int n) {
    if (n==1) return 0;
    if (n==2) return 1;
    if (n==3) return 2;
    if (n==4) return 2;
    if (n==2147483647){
      int result1, result2;
      result1 = integerReplacement(n-1);
      result2 = 2 + integerReplacement(n/2+1);
      return Math.min(result1, result2);
    }
    if (n%2==0){
      if (memo.containsKey(n)) return memo.get(n);
      int result = integerReplacement(n/2)+1;
      memo.put(n,result);
      return result;
    } 
    else {
      int result1, result2;
      if (memo.containsKey(n+1))  result1= memo.get(n+1);
      else result1 = integerReplacement( n+1 );
      if (memo.containsKey(n-1))  result2= memo.get(n-1);
      else result2 = integerReplacement( n-1 );
      int minResult = Math.min(result1+1, result2+1);
      memo.put(n,minResult);
      return minResult;
    }
  }

  private static int integerReplacement1(int n) {
    int[] memo = new int[n+1];
    memo[0] = 0;
    memo[1] = 0;
    memo[2] = 1;
    memo[3] = 2;
    memo[4] = 2;
    for (int i=5; i<=n;i++){
      if (i%2==0) memo[i] = memo[i/2]+1;
      else{
        int result1 = memo[i-1]+1;
        int result2 = memo[(i+1)/2]+2;
        memo[i] = Math.min(result1, result2);
      }
    }
    return memo[n];
  }



  public static void main(String[] args) {
    int n = 2047483646;
    System.out.println( integerReplacement(n) );
    // System.out.println( integerReplacement1(n) );
  }
}
