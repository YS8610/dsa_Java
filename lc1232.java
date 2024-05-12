public class lc1232 {
  private static boolean checkStraightLine(int[][] coordinates){
    int n = coordinates.length;
    if (n==1) return false;
    if (n==2) return true;
    
    double x1 =  coordinates[0][0];
    double y1 = coordinates[0][1];
    double x2 = coordinates[1][0];
    double y2 = coordinates[1][1];
    double dy = y2-y1;
    double dx = x2-x1;
    double gradient = dy/dx;
    if (dy ==0d && dx==0d) gradient = 0;
    else if (dx==0d) {
      for (int[] coord:coordinates){
        if (coordinates[0][0]!=coord[0] ) return false;
      }
      return true;
    }
    double c = y1-gradient*x1;
    
    for (int i=2;i<n;i++){
      double x3 = coordinates[i][0];
      double y = gradient * x3 + c;
      double y3 = coordinates[i][1];
      if (y!=y3) return false;
    }
    return true;

  }

  public static void main(String[] args) {
    int[][] coordinates = {{1,2},{2,3},{3,4},{5,6},{7,8},{9,10}};
    System.out.println( checkStraightLine(coordinates) );
  }
}
