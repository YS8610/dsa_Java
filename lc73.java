import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class lc73 {
  private static void setZeroes(int[][] matrix){
    Map<String, Set<Integer>> map = new HashMap<>();
    for (int i=0, n=matrix.length; i<n; i++ ){
      for (int j=0, m = matrix[i].length; j<m; j++){
        if ( matrix[i][j]==0) {
          if (!map.containsKey("r")) map.put("r", new HashSet<>( Arrays.asList(i) ) );
          else map.get("r").add(i);
          if (!map.containsKey("c")) map.put("c", new HashSet<>( Arrays.asList(j) ) );
          else map.get("c").add(j);
        }
      }
    }
    System.out.println( map.toString());
    if (map.containsKey("r")) {
      for (int r : map.get("r")) fill0("r",r,matrix);
    }
    if (map.containsKey("c")) {
      for (int c : map.get("c")) fill0("c",c,matrix);
    }
  }

  private static void fill0(String rc,int no, int[][] a){
    if (rc.equals("r")){
      for (int j=0, m=a[no].length; j<m;j++){
        a[no][j] = 0;
      }
    }
    else if ( rc.equals("c") ){
      for ( int i=0, n=a.length; i<n;i++){
        a[i][no] = 0;
      }
    }
  }

  public static void main(String[] args) {
    int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
    setZeroes(matrix);
    System.out.println( Arrays.toString(matrix) );
  
  }
}
