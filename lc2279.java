import java.util.Arrays;
import java.util.PriorityQueue;

public class lc2279 {
  private static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
    int l = capacity.length;
    int[][] map = new int[l][2];
    for (int i=0; i<l;i++){
      map[i][0] = rocks[i];
      map[i][1] = capacity[i];
    }
    int ans = 0;
    PriorityQueue<int[]> pq = new PriorityQueue<>(
      (m1,m2)->Integer.compare(m1[1]-m1[0], m2[1]-m2[0])
    );
    for (int[] m:map) {
      if (m[1] - m[0] == 0) ans++;
      else pq.add(m);
    }
    int[] tmp;
    while (additionalRocks != 0 && !pq.isEmpty()){
      tmp = pq.poll();
      if ((tmp[1] - tmp[0]) <= additionalRocks){
        ans++;
        additionalRocks -= tmp[1] - tmp[0]; 
      }
    }
    return ans;
  }

  private static int maximumBags1(int[] capacity, int[] rocks, int additionalRocks) {
    int l = capacity.length;
    int[][] map = new int[l][2];
    for (int i=0; i<l;i++){
      map[i][0] = rocks[i];
      map[i][1] = capacity[i];
    }
    int ans = 0;
    Arrays.sort(map, (m1,m2)->Integer.compare(m1[1]-m1[0], m2[1]-m2[0]));
    for (int[] m:map){
      if (m[1]-m[0] == 0){
        ans++;
        continue;
      };
      if ((m[1]-m[0]) <= additionalRocks){
        ans++;
        additionalRocks-= m[1]-m[0];
      }
      else break;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] capacity = {2,3,4,5}, rocks = {1,2,4,4};
    int additionalRocks = 2;
    System.out.println(maximumBags(capacity, rocks, additionalRocks));
  }
}
