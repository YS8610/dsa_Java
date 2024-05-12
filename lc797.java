import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lc797 {
  
  private static List<List<Integer>> allPathsSourceTarget(int[][] graph){
    int target = graph.length-1;
    List<List<Integer>> ans = helper(graph,0,target);
    ans.stream().forEach( x -> {
      x.add(0);
      Collections.reverse(x);
    });
    return ans;
  }

  private static List<List<Integer>> helper( int[][] graph,int source,int target ){
    if (source == target) {
      List<List<Integer>> list = new ArrayList<>();
      list.add(new ArrayList<>());
      return list;
    }
    if (graph[source].length==0) return null;

    List<List<Integer>> temp = new ArrayList<>();
    for (int i=0, n=graph[source].length;i<n;i++){
      List<List<Integer>> subTarget =  helper(graph, graph[source][i], target);
      if (subTarget!= null){
        for (int j=0, m=subTarget.size();j<m;j++){
          subTarget.get(j).add(graph[source][i]);
        }
        temp.addAll(subTarget);
      }
    }
    return temp;
  }

  public static void main(String[] args) {
    int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
    System.out.println( allPathsSourceTarget(graph) );
  }
}
