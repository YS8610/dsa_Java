import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class lc743 {
  public int networkDelayTime(int[][] times, int n, int k) {
    Map<Integer, List<int[]>> map = new HashMap<>();
    for (int[] t:times){
      if (map.containsKey(t[0]))
        map.get(t[0]).add(new int[]{t[1], t[2]});
      else
        map.put(t[0], new ArrayList<>(List.of(new int[]{t[1],t[2]})));
    }
    int[] time = new int[n+1];
    int[] tmp;
    Arrays.fill(time,-1);
    time[0] = 0;
    time[k] = 0;
    PriorityQueue<int[]> pq = new PriorityQueue<>( (m1,m2) -> Integer.compare(m1[1], m2[1]));
    pq.add(new int[]{k,0});
    while (!pq.isEmpty()){
      tmp = pq.poll();
      if (!map.containsKey(tmp[0])) continue;
      for (int[] edge : map.get(tmp[0])){
        if (time[edge[0]] == -1){
          pq.add(edge);
          time[edge[0]] = time[tmp[0]] + edge[1];
        }
        else{
          if (time[edge[0]] <= time[tmp[0]] + edge[1]) continue;
          time[edge[0]] = time[tmp[0]] + edge[1];
          pq.add(edge);
        }
      }
    }
    int ans = 0;
    for (int t:time){
      if (t==-1) return -1;
      ans = Math.max(t, ans);
    }
    return ans;
  }
}
