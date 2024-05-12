import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc63 {
  private static int uniquePathsWithObstacles(int[][] obstacleGrid){
    if (obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1) return 0;
    return uniquePath1(obstacleGrid.length-1, obstacleGrid[0].length-1 , obstacleGrid);
    // List<String> obstacle = new ArrayList<>();
    // for (int i=0,x=obstacleGrid.length; i<x;i++){
    //   for (int j=0,y=obstacleGrid[i].length;j<y;j++ ){
    //     if (obstacleGrid[i][j] == 1) {
    //       obstacle.add(String.valueOf(i)+","+String.valueOf(j));
    //     }
    //   }
    // }
    
    // return uniquePath(obstacleGrid.length-1, obstacleGrid[0].length-1 , obstacle);
  }

  private static Map<String,Integer> memo = new HashMap<>(); 
  private static int uniquePath(int n, int m , List<String> obstacle){
    if (n<0 || m <0) return 0;
    if (n==0 && m ==0) return 1;
    if ( obstacle.contains(String.valueOf(n)+","+String.valueOf(m)) ) return 0;
    if (memo.containsKey(String.valueOf(n)+","+String.valueOf(m))) return memo.get(String.valueOf(n)+","+String.valueOf(m));
    String coordinate1 = String.valueOf(n-1)+","+String.valueOf(m);
    String coordinate2 = String.valueOf(n)+","+String.valueOf(m-1);
    if ( obstacle.contains(coordinate1)) return uniquePath(n, m-1, obstacle);
    if ( obstacle.contains(coordinate2)) return uniquePath(n-1, m, obstacle);
    
    int path1 = uniquePath(n-1, m, obstacle);
    int path2 = uniquePath(n, m-1, obstacle);
    memo.put( String.valueOf(n-1)+","+String.valueOf(m) , path1);
    memo.put( String.valueOf(n)+","+String.valueOf(m-1) , path2);

    return path1 + path2 ;
  }

  private static int uniquePath1(int n, int m , int[][] obstacleGrid){
    if (n<0 || m <0) return 0;
    if (n==0 && m ==0) return 1;
    if ( obstacleGrid[n][m] ==1 ) return 0;
    if (memo.containsKey(String.valueOf(n)+","+String.valueOf(m))) return memo.get(String.valueOf(n)+","+String.valueOf(m));
    if ( obstacleGrid[n-1<0?0:n-1][m] ==1) return uniquePath1(n, m-1, obstacleGrid);
    if ( obstacleGrid[n][m-1<0?0:m-1] ==1) return uniquePath1(n-1, m, obstacleGrid);
    
    int path1 = uniquePath1(n-1, m, obstacleGrid);
    int path2 = uniquePath1(n, m-1, obstacleGrid);
    memo.put( String.valueOf(n-1)+","+String.valueOf(m) , path1);
    memo.put( String.valueOf(n)+","+String.valueOf(m-1) , path2);

    return path1 + path2 ;
  }


  public static void main(String[] args) {
    int[][] obstacleGrid = {{0,1},{1,0}};
    System.out.println( uniquePathsWithObstacles(obstacleGrid) );
  }
}
