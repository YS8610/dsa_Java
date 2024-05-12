import java.util.HashMap;
import java.util.Map;

public class lc62 {
  private static Map<String,Integer> memo = new HashMap<>();
  private static int uniquePaths(int m, int n){
    if (m==1 && n==1) return 1;
    if (m==0 || n ==0 ) return 0;
    if (memo.containsKey( String.valueOf(m)+","+String.valueOf(n) )  ) return memo.get(String.valueOf(m)+","+String.valueOf(n));
    
    int path1 = uniquePaths(m-1,n);
    memo.put(String.valueOf(m-1)+","+String.valueOf(n), path1);
    int path2 = uniquePaths(m, n-1);
    memo.put(String.valueOf(m)+","+String.valueOf(n-1), path2);
    return path1+ path2;
  }
  public static void main(String[] args) {
    int m = 3, n = 3;
    System.out.println(uniquePaths(m, n));
  }
}
