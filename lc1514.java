import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class lc1514 {
  private static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
    Map<Integer, Set<double[]>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    PriorityQueue<double[]> pq = new PriorityQueue<>((m1,m2) -> Double.compare(m2[1], m1[1]));
    for (int i=0, m=edges.length; i<m;i++){
      if (map.containsKey(edges[i][0])){
        map.get(edges[i][0]).add(new double[]{edges[i][1], succProb[i]});
      }
      if (map.containsKey(edges[i][1])){
        map.get(edges[i][1]).add(new double[]{edges[i][0], succProb[i]});
      }
      if (!map.containsKey(edges[i][0])){
        map.put(edges[i][0], new HashSet<>());
        map.get(edges[i][0]).add(new double[]{edges[i][1], succProb[i]});
      }
      if (!map.containsKey(edges[i][1])){
        map.put(edges[i][1], new HashSet<>());
        map.get(edges[i][1]).add(new double[]{edges[i][0], succProb[i]});
      }
    }

    pq.add(new double[]{start_node, 1});
    double[] tmp;
    while (!pq.isEmpty()){
      tmp = pq.poll();
      if ((int)tmp[0] == end_node) return tmp[1];
      if (visited.contains((int)tmp[0])) continue;
      visited.add((int)tmp[0]);
      if (!map.containsKey((int)tmp[0])) break;
      for (double[] path : map.get((int)tmp[0])){
        path[1] = path[1] * tmp[1];
        pq.add(path);
      }
    }
    return 0d;
  }

  public static void main(String[] args) {
    int n = 3;
    // int[][] edges = {{0,1},{1,2},{0,2}};
    int[][] edges = {{0,1}};
    // double[] succProb = {0.5,0.5,0.2};
    double[] succProb = {0.5};
    int start = 0, end = 2;
    System.out.println(maxProbability(n, edges, succProb, start, end));
  }
}
