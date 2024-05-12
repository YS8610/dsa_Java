import java.util.HashMap;

public class lc70{
  static private HashMap<Integer,Integer> memo = new HashMap<>();
  private static int climbStairs(int n){
    if (n==1) return 1;
    if (n==2) return 2;
    if (n==3) return 3;
    if ( memo.containsKey(n) ) return memo.get(n);
    memo.put(n,climbStairs(n-1)+climbStairs(n-2) );
    return climbStairs(n-1)+climbStairs(n-2);
  }
  public static void main(String[] args) {
    
    System.out.println( climbStairs(45) );
  }
}