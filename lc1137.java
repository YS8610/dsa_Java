import java.util.HashMap;

public class lc1137 {

  private static HashMap<Integer,Integer> memo = new HashMap<>();

  private static int tribonacci(int n){
    if (n==0) return 0;
    if (n==1) return 1;
    if (n==2) return 1;
    if (memo.containsKey(n) ) return memo.get(n);
    // int ans = tribonacci(n-3) + tribonacci(n-2) + tribonacci(n-1);
    memo.put(n, tribonacci(n-3) + tribonacci(n-2) + tribonacci(n-1));

    return memo.get(n);

  }
  public static void main(String[] args) {
    System.out.println(tribonacci(40));
  }
}
