import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc1992 {
  private static void dfs(int[][] land, int r, int c){
    int rlen = land.length;
    int clen = land[0].length;
    if (r < 0 || c < 0 || r >= rlen || c >= clen || land[r][c] == 2 || land[r][c] == 0) return;
    land[r][c] = 2;
    dfs(land, r+1, c);
    dfs(land, r, c+1);
  }
  
  private static int[][] findFarmland(int[][] land) {
    int rlen = land.length;
    int clen = land[0].length;
    List<int[]> coor = new ArrayList<>();
    for (int r = 0; r < rlen ; r++){
      for (int c = 0; c < clen; c++){
        if (land[r][c] == 0 || land[r][c] == 2) continue;
        coor.add(new int[]{r,c});
        dfs(land, r, c);
      }
    }
    int[][] ans = new int[coor.size()][4];
    int j;
    for (int i =0, n = coor.size();i<n;i++){
      ans[i][0] = coor.get(i)[0];
      ans[i][1] = coor.get(i)[1];
      j = 0;
      while (ans[i][0] + j < rlen && land[ans[i][0] + j][ans[i][1]] == 2) j++;
      ans[i][2] = coor.get(i)[0] + j - 1;
      j = 0;
      while (ans[i][1] + j < clen && land[ans[i][0]][ans[i][1] + j] == 2) j++;
      ans[i][3] = coor.get(i)[1] + j - 1;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] land = {{1,0,0},{0,1,1},{0,1,1}};
    System.out.println(Arrays.deepToString(findFarmland(land)));
    System.out.println(Arrays.deepToString(land));
  }
}
