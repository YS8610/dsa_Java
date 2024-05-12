import java.util.ArrayList;
import java.util.List;

public class lc54 {

  private static List<Integer> spiralOrder(int[][] matrix) {
    int rlen = matrix.length;
    int clen = matrix[0].length;
    List<Integer> ans = new ArrayList<>(rlen * clen);
    int lp = 0, rp = clen - 1;
    int up = 0, dp = rlen - 1;
    while (lp != rp || up != dp) {
      if (up!=dp){
        for (int i = lp; i <= rp; i++) ans.add(matrix[lp][i]);
        up++;
      }
      else{
        for (int i = lp; i <= rp; i++) ans.add(matrix[lp][i]);
        break;
      }
      if (lp!=rp){
        for (int i = up; i <= dp; i++) ans.add(matrix[i][rp]);
        rp--;
      }
      else{
        for (int i = up; i <= dp; i++) ans.add(matrix[i][rp]);
        break;
      }
      if (up!=dp){
        for (int i=rp; i>=lp;i--) ans.add(matrix[dp][i]);
        dp--;
      }
      else{
        for (int i=rp; i>=lp;i--) ans.add(matrix[dp][i]);
        break;
      }
      if (lp!=rp){
        for(int i=dp; i>=up;i--) ans.add(matrix[i][lp]);
        lp++;
      }
      else{
        for(int i=dp; i>=up;i--) ans.add(matrix[i][lp]);
        break;
      }
    }
    if (clen==rlen && clen%2!=0) ans.add(matrix[clen/2][clen/2]); 
    return ans;
  }

  public static void main(String[] args) {
    int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    // int[][] matrix = {
    //   {1, 2,  3,  4},
    //   {5, 6,  7,  8},
    //   {9, 10, 11, 12}
    // };
    System.out.println(spiralOrder(matrix).toString());
  }
}
