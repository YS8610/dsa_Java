import java.util.ArrayList;
import java.util.List;

public class lc1492 {
  private static int kthFactor(int n, int k) {
    int m = (int)Math.sqrt(n);
    List<Integer> factor = new ArrayList<>();
    if (n==1){
      factor = List.of(1);
      if (k>factor.size()) return -1;
      return factor.get(k-1);
    }
    if (n==2){
      factor = List.of(1,2);
      if (k>factor.size()) return -1;
      return factor.get(k-1);
    }
    factor.add(1);
    factor.add(n);
    for (int i = 2; i<=m; i++){
      if (n%i==0) {
        factor.add(i);
        if (i!= n/i) factor.add(n/i);
      }
    }
    factor.sort((m1,m2) -> Integer.compare(m1, m2));
    System.out.println(factor);
    if (k>factor.size()) return -1;
    return factor.get(k-1);
  }

  public static void main(String[] args) {
    int n = 1000, k = 5;
    System.out.println(kthFactor(n, k));
  }
}
