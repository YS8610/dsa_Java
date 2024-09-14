import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class lc264 {
  private static int nthUglyNumber(int n) {
    if (n==1) return 1;
    int l = 5*3*2*2;
    boolean[] dp = new boolean[l];
    Arrays.fill(dp,false);
    dp[1] = true;
    for (int i = 1;i<l;i++){
      if (!dp[i]) continue;
      if (i * 2 < l) dp[i*2] = true;
      if (i * 3 < l) dp[i*3] = true;
      if (i * 5 < l) dp[i*5] = true;
    }
    int counter=0;
    for (int i=0;i<l;i++){
      if (dp[i]) counter++;
      if (counter==n) return i;
    }
    return 0;
  }

  private static int nthUglyNumber1(int n) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Set<Integer> set = new HashSet<>();
    int lmt1 = Integer.MAX_VALUE/2;
    int lmt2 = Integer.MAX_VALUE/3;
    int lmt3 = Integer.MAX_VALUE/5;
    int tmp=1;
    pq.add(1);
    set.add(1);
    int count = 0;
    while (!pq.isEmpty() && count < n){
      tmp = pq.poll();
      count++;
      if (!set.contains(tmp * 2) && tmp < lmt1){
        pq.add(tmp*2);
        set.add(tmp*2);
      }
      if (!set.contains(tmp * 3) && tmp < lmt2){
        pq.add(tmp*3);
        set.add(tmp*3);
      }
      if (!set.contains(tmp * 5) && tmp < lmt3){
        pq.add(tmp*5);
        set.add(tmp*5);
      }
    }
    // List<Integer> l = new ArrayList<>(set);
    // Collections.sort(l);
    return tmp;
  }

  public static void main(String[] args) {
    int n = 500;
    // System.out.println(nthUglyNumber(n));
    System.out.println(nthUglyNumber1(n));
  }
}
