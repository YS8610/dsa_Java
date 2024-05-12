import java.util.HashMap;
import java.util.Map;

public class lc509 {

  private static HashMap<Integer,Integer> memo = new HashMap<>(Map.of(0,0));

  private static int fib(int n){
    if (n == 0) return 0;
    if (n == 1) return 1;
    if (memo.containsKey(n)) return memo.get(n);
    memo.put(n,fib(n-1)+fib(n-2));

    return memo.get(n);
  }

  public static void main(String[] args) {
    
    System.out.println(fib(40)); 
  }
}
// 1,1,2,3,5,8,13