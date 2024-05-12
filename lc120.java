import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc120 {
  
  private static Map<List<List<Integer>>, Integer> memo = new HashMap<>();

  private static int minimumTotalR(List<List<Integer>> triangle){
    int n = triangle.size();
    if (n==1) return triangle.get(0).get(0);
    if (n==2){
      int min = Math.min( triangle.get(1).get(0), triangle.get(1).get(1) );
      return min + triangle.get(0).get(0);
    }
    if (memo.containsKey(triangle)) return memo.get(triangle);

    List<List<Integer>> t1 = new ArrayList<>();
    for (int i=1;i<n;i++){
      List<Integer> layer =  triangle.get(i).subList(0,triangle.get(i).size()-1 );
      List<Integer> tmp = new ArrayList<>( layer );
      t1.add( new ArrayList<>(tmp));
    }
    List<List<Integer>> t2 = new ArrayList<>();
    for (int i=1;i<n;i++){
      List<Integer> layer =  triangle.get(i).subList(1,triangle.get(i).size() );
      List<Integer> tmp = new ArrayList<>( layer );
      t2.add( new ArrayList<>(tmp));
    }

    int ans = triangle.get(0).get(0) + Math.min(minimumTotalR(t1), minimumTotalR(t2));
    memo.put(triangle, ans);

    return ans;
  }

  private static int minimumTotalT(List<List<Integer>> triangle){
    int n = triangle.size();
    int top = triangle.get(0).get(0);
    if (n==1) return triangle.get(0).get(0);
    if (n==2) return Math.min( triangle.get(1).get(0) + top , triangle.get(1).get(1) + top);
    
    int[][] ans = new int[n-1][];
    for (int i =0; i<n-1; i++ ){
      ans[i] = new int[i+1];
    }
    for (int j=0, m= ans[n-2].length ; j<m; j++){
      ans[n-2][j] = Math.min(triangle.get(n-1).get(j) , triangle.get(n-1).get(j+1));
      ans[n-2][j] +=  triangle.get(n-2).get(j);
    }
    for (int i=ans.length-2; i>0;i--){
      if (i==0) break;
      for (int j=0; j<=i;j++){
        ans[i][j] = Math.min(ans[i+1][j] , ans[i+1][j+1] );
        ans[i][j] += triangle.get(i).get(j);
      }
    }
    return Math.min(ans[1][0]+top, ans[1][1]+top);
  }
  public static void main(String[] args) {
    List<List<Integer>> triangle = new ArrayList<>();
    triangle.add( Arrays.asList(2));
    triangle.add( Arrays.asList(3,4));
    triangle.add( Arrays.asList(6,5,7));
    triangle.add( Arrays.asList(4,1,8,3));
    triangle.add( Arrays.asList(1,10,8,4,2));
  
    System.out.println(triangle.toString());
    System.out.println(minimumTotalR(triangle));
    System.out.println(minimumTotalT(triangle));
  }
}
