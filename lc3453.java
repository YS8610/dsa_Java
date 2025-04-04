public class lc3453 {
  private static double separateSquares(int[][] squares) {
    int l = squares.length;
    double ans = 0;
    double lp = squares[0][1];
    double rp = squares[l-1][1] + squares[l-1][2];
    for (int[] s:squares){
      lp = Math.min(lp, s[1]);
      rp = Math.max(rp, s[1]+s[2]);
    }
    int tmp;
    while (lp < rp){
      ans = (rp - lp) /2d + lp;
      tmp = uparea(squares, ans);
      if (tmp > 0)
        lp = ans;
      else
        rp = ans;
      if (Math.abs(rp - lp) <= 0.000001)
        break;
    }
    return ans;
  }

  private static int uparea(int[][] squares, double y){
    double up = 0;
    double down = 0;

    for (int[] sq : squares){
      // totally above
      if ( sq[1] >= y){
        up += sq[2] * (double)sq[2];
        continue;
      }
      // totally below
      if (sq[1] + sq[2] <= y){
        down += sq[2] * (double)sq[2];
        continue;
      }
      // down overlapped
      down += (y - sq[1]) * (double)sq[2];
      up += (sq[1] + sq[2] - y) * (double)sq[2];
    }
    return Double.compare(up, down);
  }

  public static void main(String[] args) {
    int[][] squares = {
      {522261215,954313664,461744743},
      {628661372,718610752,21844764},
      {619734768,941310679,91724451},
      {352367502,656774918,591943726},
      {860247066,905800565,853111524},
      {817098516,868361139,817623995},
      {580894327,654069233,691552059},
      {182377086,256660052,911357},
      {151104008,908768329,890809906},
      {983970552,992192635,462847045}
    };
    System.out.println(separateSquares(squares));
  }
}
